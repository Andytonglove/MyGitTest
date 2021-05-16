// MAPTestFor0422.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <stdio.h>
#include <iostream>
#include <queue>
#include <string>
#include "Timer.h"
#include <fstream>
using namespace std;

/*
* 已选：
1）CSV格式数据文件的读写
2）图的创建（邻接矩阵或邻接表）
3）图的遍历（广度优先或深度优先）
4）图的最短路径，并具体给出（A到B）的最短路径（如时间）及其数值
5）最短路径的地图可视化展示
6）算法的复杂度分析（如时间）
要求：
按照“数据结构与算法”课程要求，进行规范的数据结构、算法、以及ADT设计，
并进行算法的时间和空间复杂度分析和实际统计，算法、代码注释清晰易读
*/

#define MAX 100e6
#define CITYSIZE 199
#define ROUTESIZE 1975

class Route
{   //路线类（类型为边）
public:
    string origin_city;   //路线起点
    string destination_city;     //路线终点
    string m_transport;    //交通工具
    string other_information;   //其他信息

    float m_cost;   //花费
    float m_time;   //时间
};

class Graph
{
public:
    Route* r;   //路线
    float m_cost;   //路线花费
    float m_time;   //路线耗时
    Graph() { m_cost = m_time = MAX; r = NULL; }   //构造函数，全部初始化为Infinity
    ~Graph() {};   //析构函数
};

class City
{   //城市类（类型为点）
public:
    string m_country;   //国家
    string m_city;   //城市

    float m_latitude;   //纬度
    float m_longitude;   //经度
};

/*全局变量定义*/
int isTrav[199] = { 0 };   //遍历记录数组
Graph MatrixGraph[199][199];   //核心操作对象：存储数据的图
City city[199];   //城市数组
Route route[1975];   //路线数组

void ReadCities(const char* filename, City* ct)
{   //读取城市信息函数
    FILE* fp = NULL;
    errno_t err;
    err = fopen_s(&fp, filename, "r");   //用安全函数fopen_s打开代替原先的fopen
    if (err!=0) {
        cout << "无法打开该文件！";   //文件无法打开
    }
    else {
        char ch;
        int i = 0;
        while (!feof(fp) && i < 199)   //fp没有读到文件结束并且城市没有读取完
        {
            ch = fgetc(fp);
            for (; ch != ','; ch = fgetc(fp))
            {
                ct[i].m_country += ch;
            }
            ch = fgetc(fp);
            for (; ch != ','; ch = fgetc(fp))
            {
                ct[i].m_city += ch;
            }
            fscanf_s(fp, "%f,", &ct[i].m_latitude);
            fscanf_s(fp, "%f\n", &ct[i].m_longitude);
            i++;   //继续读取下一行的数据
        }
    }
    fclose(fp);   //关闭指针

    //读取城市信息函数的空间复杂度
    int size = sizeof(*ct);
    cout << "ReadCities->Use of space:" << size << endl;
}

void ReadRoutes(const char* filename, Route* routes)
{   //读取路线信息文件函数，实现要素同上
    FILE* fp = NULL;
    fopen_s(&fp, filename, "r");
    if (!fp) {
        cout << "无法打开该文件！" << endl;
    }
    else
    {
        char ch;
        int i = 0;
        while (!feof(fp) && i < 1975)
        {
            ch = fgetc(fp);
            while (ch != ',')
            {
                routes[i].origin_city += ch;
                ch = fgetc(fp);
            }

            ch = fgetc(fp);
            while (ch != ',')
            {
                routes[i].destination_city += ch;
                ch = fgetc(fp);
            }

            ch = fgetc(fp);
            while (ch != ',')
            {
                routes[i].m_transport += ch;
                ch = fgetc(fp);
            }

            fscanf_s(fp, "%f,", &routes[i].m_time);
            fscanf_s(fp, "%f\n", &routes[i].m_cost);

            ch = fgetc(fp);
            while (ch != '\n')
            {
                routes[i].other_information += ch;
                ch = fgetc(fp);
            }
            i++;
        }
    }
    fclose(fp);

    //读取最短路径函数的空间复杂度
    int size = sizeof(*routes);
    cout << "ReadRoutes->Use of space:" << size << endl;
}

int Locate(string city, City* _city)
{   //在城市类的数组中找到城市位置数
    for (int i = 0; i < 199; i++) {
        if (_city[i].m_city == city) {
            return i;   //找到了则返回找到该城市的的编号
        }
    }
    return -1;   //否则返回-1
}

void CreateMatrixGraph() {   
    //图的创建邻接矩阵
    for (int i = 0; i < 199; i++) {
        for (int j = 0; j < 199; j++) {
            if (i == j) {
                MatrixGraph[i][j].m_cost = MatrixGraph[i][j].m_time = 0;   //初始化所有自身连接为0
            }
            else {
                MatrixGraph[i][j].m_cost = MAX;   //初始化外界连接为Infinity
                MatrixGraph[i][j].m_time = MAX;
            }
        }
    }
    for (int i = 0; i < 1975; i++) {
        int begin, end;
        begin = Locate(route[i].origin_city, city);
        end = Locate(route[i].destination_city, city);   //将路线起始点和终点的序号定位
        MatrixGraph[begin][end].m_cost = route[i].m_cost;   //将路程的花费和时间赋给图的cost和time变量
        MatrixGraph[begin][end].m_time = route[i].m_time;
        MatrixGraph[begin][end].r = &route[i];   //将路程赋给路程指针储存
    }

    //图的邻接矩阵的空间复杂度
    int size = sizeof(*route) + sizeof(MatrixGraph) + sizeof(city);
    cout << "CreateMatrixGraph->Use of space:" << size << endl;
}

//第二题：图的遍历
//图的遍历算法1：（选择BFS广度优先遍历算法实现）
void BFSfunction(int i)
{   //可选第二题：图的遍历（选择BFS广度优先遍历算法实现）
    int j;
    queue<int>Q;   //使用int型队列
    isTrav[i] = 1;   //遍历记录数组的初始化
    cout << "->" << city[i].m_city;   //输出
    Q.push(i);   //在队列末尾加上i
    while (!Q.empty())
    {
        Q.pop();   //Q若不为空则删除掉第一个元素并执行如下操作
        for (j = 0; j < 199; j++)
        {
            if (MatrixGraph[i][j].m_cost != 10000 && !isTrav[j])
            {
                cout << "->" << city[j].m_city;
                isTrav[j] = 1;
                Q.push(j);   //若该点没有遍历或者不通到则需要遍历，遍历结束则将该点标记，再遍历下一个
            }
        }
    }

    //图的BFS遍历的空间复杂度
    int size = sizeof(isTrav) + sizeof(Q) + sizeof(MatrixGraph);
    cout << endl << "BFSfunction->Use of space:" << size << endl;   //结果为所用空间字节数：476028
}
void BFSTraverse(int pos)
{   //显示路径函数
    int i;
    for (i = 0; i < 199; i++)
        isTrav[i] = 0;   //先将全部初始化为0，然后逐步遍历
    for (i = 0; i < 199; i++)
    {
        if (!isTrav[(i + pos) % 199])
            BFSfunction((i + pos) % 199);   //递归算法完成路径的遍历
    }
}

//图的遍历算法2：（选择DFS深度优先遍历算法实现）
void DFS(City* ct, int i)
{
    //DFS深度优先遍历，用第二种种方式实现遍历！
    isTrav[i] = 1;   //初始点设置为1（访问过）
    cout << ct[i].m_city << "->";
    for (int j = 0; j < CITYSIZE; j++)   //从第0个顶点开始判断到最后一个
    {
        if (MatrixGraph[i][j].m_cost != 10000 && !isTrav[j])   //如果城市i到城市j有路径，且j未访问，则进行递归	
            DFS(ct, j);
    }
}
void DFSTraverse(City* ct)
{
    for (int i = 0; i < CITYSIZE; i++)
        isTrav[i] = 0;   //初始化，将所有顶点都设定为未访问过
    for (int i = 0; i < CITYSIZE; i++)
        if (!isTrav[i])
            DFS(ct, i);   //若未被访问则进行DFS遍历，防止未连通
    cout << endl;
}

void ShortestPath(int pre[], int begin, float time[])
{   //最短路径查询，ps:评判标准为最短时间
    int i, j, k;
    float min;
    float tem;
    int get[199];   //选取数组
    for (i = 0; i < 199; i++)
    {
        get[i] = 0;
        pre[i] = -1;   //pre数组，记录上一个点
        time[i] = MatrixGraph[begin][i].m_time;   //初始化和时间参数
    }
    get[begin] = 1;
    time[begin] = 0;   //对起始点的初始化
    for (i = 0; i < 199; i++)
    {
        if (time[i] != 0 && time[i] != 10000)   //如果该点不是当前点或无法到达点
            pre[i] = begin;   //前一个点，即路径的记录
    }
    for (i = 0; i < 198; i++)
    {
        min = MAX;
        for (j = 0; j < 199; j++)
        {
            if (get[j] == 0 && time[j] < min)
            {
                min = time[j];
                k = j;   //根据贪婪算法，遍历并且找到本回合中时间最短的路径
            }
        }
        get[k] = 1;   //取中该点
        for (j = 0; j < 199; j++)   //对剩余的点进行更新操作
        {
            if (j != k && MatrixGraph[k][j].m_time < 10000)
            {
                tem = (time[k] + MatrixGraph[k][j].m_time);   //该点的权值即到达时间改为原值加新值
                if (get[j] == 0 && (tem < time[j]))
                {
                    time[j] = tem;   
                    pre[j] = k;
                }
            }
        }
    }
    //最短路径函数的空间复杂度
    int size = sizeof(get) + sizeof(pre) + sizeof(time) + sizeof(MatrixGraph);
    cout << "ShortestPath->Use of space:" << size << endl;   //结果为所用空间字节数：476016
}

//第5题：可视化的完成
void Dispath(int path[], City _ct[], int start, int end, int *path_ct, int& num) {
    //显示路径函数
    int i = 0, j = 0;
    int k = end;
    int pNew[ROUTESIZE];   //储存路径的数组
    int n = 1;
    for (;; i++) {
        if (path[end] == start) break;       //循环将路径存入数组pNew
        pNew[i] = path[end];
        end = pNew[i];
        j++;
    }
    num = j + 2;
    path_ct[0] = start;   //路径的初始化
    cout << "路线为：" << _ct[start].m_city;      //输出路径，起点->循环输出路径->终点
    for (i = j - 1; i >= 0; i--, n++) {
        cout << " " << _ct[pNew[i]].m_city;
        path_ct[n] = pNew[i];
    }
    path_ct[num - 1] = k;   //在终点的前一个点结束并输出终点
    cout << " " << _ct[k].m_city << "\n";
}

void writeFile(int path_ct[], int num, City *ct) {
    //可选第5题：输出最短路径到百度地图，可视化的完成
    fstream ioFile;
    ioFile.open("graph.html", ios::out);
    ioFile << "<!DOCTYPE html><html><head><style type='text/css'>body, html{width: 100%;height: 100%;margin:0;font-family:'微软雅黑';}#allmap{height:100%;width:100%;}#r-result{width:100%;}</style><script type='text/javascript' src='http://api.map.baidu.com/api?v=2.0&ak=nSxiPohfziUaCuONe4ViUP2N'></script><title>Shortest path from Beijing to London</title></head><body><div id='allmap'></div></div></body></html><script type='text/javascript'>var map = new BMap.Map('allmap');var point = new BMap.Point(0, 0);map.centerAndZoom(point, 2);map.enableScrollWheelZoom(true);" << "\n";
    ioFile << "var marker0 = new BMap.Marker(new BMap.Point(" << ct[path_ct[0]].m_longitude << ", " << ct[path_ct[0]].m_latitude << ")); map.addOverlay(marker0);" << "\n";
    ioFile << "var infoWindow0 = new BMap.InfoWindow(\"<p style = 'font-size:14px;'>country: " << ct[path_ct[0]].m_country << "<br/>city: " << ct[path_ct[0]].m_city << "</p>\");marker0.addEventListener(\"click\", function(){this.openInfoWindow(infoWindow0);}); " << "\n";
    for (int i = 1; i < num - 1; i++) {   //循环输出每一个点
        ioFile << "var marker" << i << " = new BMap.Marker(new BMap.Point(" << ct[path_ct[i]].m_longitude << ", " << ct[path_ct[i]].m_latitude << ")); map.addOverlay(marker" << i << ");" << "\n";
        ioFile << "var infoWindow" << i << " = new BMap.InfoWindow(\"<p style = 'font-size:14px;'>country: " << ct[path_ct[i]].m_country << "<br/>city: " << ct[path_ct[i]].m_city << "</p>\");marker" << i << ".addEventListener(\"click\", function(){this.openInfoWindow(infoWindow" << i << ");}); " << "\n";
        ioFile << "var contentString0" << i << " = '" << ct[path_ct[i - 1]].m_city << ", " << ct[path_ct[i - 1]].m_country << " --> " << ct[path_ct[i]].m_city << "," << ct[path_ct[i]].m_country << " (" << MatrixGraph[path_ct[i - 1]][path_ct[i]].r->m_transport << " - " << MatrixGraph[path_ct[i - 1]][path_ct[i]].m_time << " - " << MatrixGraph[path_ct[i - 1]][path_ct[i]].m_cost << " - \"" << MatrixGraph[path_ct[i - 1]][path_ct[i]].r->other_information << "\")';var path" << i << " = new BMap.Polyline([new BMap.Point(" << ct[path_ct[i - 1]].m_longitude << ", " << ct[path_ct[i - 1]].m_latitude << "),new BMap.Point(" << ct[path_ct[i]].m_longitude << ", " << ct[path_ct[i]].m_latitude << ")], {strokeColor:'#18a45b', strokeWeight:8, strokeOpacity:0.8});map.addOverlay(path" << i << ");path" << i << ".addEventListener(\"click\", function(){alert(contentString0" << i << ");});var marker" << i << " = new BMap.Marker(new BMap.Point(" << ct[path_ct[i]].m_longitude << ", " << ct[path_ct[i]].m_latitude << "));map.addOverlay(marker" << i << ");" << "\n";
        ioFile << "var infoWindow" << i << " = new BMap.InfoWindow(\"<p style = 'font-size:14px;'>country: " << ct[path_ct[i]].m_country << "<br/>city: " << ct[path_ct[i]].m_city << "</p>\");marker" << i << ".addEventListener(\"click\", function(){this.openInfoWindow(infoWindow" << i << ");}); " << "\n";
    }
    ioFile << "var marker" << num - 1 << " = new BMap.Marker(new BMap.Point(" << ct[path_ct[num - 1]].m_longitude << ", " << ct[path_ct[num - 1]].m_latitude << ")); map.addOverlay(marker" << num - 1 << ");" << "\n";
    ioFile << "var infoWindow" << num - 1 << " = new BMap.InfoWindow(\"<p style = 'font-size:14px;'>country: " << ct[path_ct[num - 1]].m_country << "<br/>city: " << ct[path_ct[num - 1]].m_city << "</p>\");marker" << num - 1 << ".addEventListener(\"click\", function(){this.openInfoWindow(infoWindow" << num - 1 << ");}); " << "\n";
    ioFile << "var contentString0" << num - 1 << " = '" << ct[path_ct[num - 2]].m_city << ", " << ct[path_ct[num - 2]].m_country << " --> " << ct[path_ct[num - 1]].m_city << "," << ct[path_ct[num - 1]].m_country << " (" << MatrixGraph[path_ct[num - 2]][path_ct[num - 1]].r->m_transport << " - " << MatrixGraph[path_ct[num - 2]][path_ct[num - 1]].m_time << " - " << MatrixGraph[path_ct[num - 2]][path_ct[num - 1]].m_cost << " - \"" << MatrixGraph[path_ct[num - 2]][path_ct[num - 1]].r->other_information << "\")';var path" << num - 1 << " = new BMap.Polyline([new BMap.Point(" << ct[path_ct[num - 2]].m_longitude << ", " << ct[path_ct[num - 2]].m_latitude << "),new BMap.Point(" << ct[path_ct[num - 1]].m_longitude << ", " << ct[path_ct[num - 1]].m_latitude << ")], {strokeColor:'#18a45b', strokeWeight:8, strokeOpacity:0.8});map.addOverlay(path" << num - 1 << ");path" << num - 1 << ".addEventListener(\"click\", function(){alert(contentString0" << num - 1 << ");});var marker" << num - 1 << " = new BMap.Marker(new BMap.Point(" << ct[path_ct[num - 1]].m_longitude << ", " << ct[path_ct[num - 1]].m_latitude << "));map.addOverlay(marker" << num - 1 << ");" << "\n";
    ioFile << "</script>";
    ioFile.close();
    cout << "可视化展示已输出在文件'graph.html'中" << endl;
}

//////////////////////////////////////////////////////////////////
//最短路径的另一种评判方式：花费最少版
void ShortestPathcost(int pre[], int begin, float cost[])
{   //最短路径查询，ps:评判标准为最少花费
    int i, j, k;
    float min;
    float tem;
    int get[199];   //选取数组
    for (i = 0; i < 199; i++)
    {
        get[i] = 0;
        pre[i] = -1;   //pre数组
        cost[i] = MatrixGraph[begin][i].m_cost;   //初始化和花费参数
    }
    get[begin] = 1;
    cost[begin] = 0;   //对起始点的初始化
    for (i = 0; i < 199; i++)
    {
        if (cost[i] != 0 && cost[i] != 10000)   //如果该点不是当前点或无法到达点
            pre[i] = begin;   //前一个点，即路径的记录
    }
    for (i = 0; i < 198; i++)
    {
        min = MAX;
        for (j = 0; j < 199; j++)
        {
            if (get[j] == 0 && cost[j] < min)
            {
                min = cost[j];
                k = j;   //根据贪婪算法，遍历并且找到本回合中花费最少的路径
            }
        }
        get[k] = 1;   //取中该点
        for (j = 0; j < 199; j++)   //对剩余的点进行更新操作
        {
            if (j != k && MatrixGraph[k][j].m_time < 10000)
            {
                tem = (cost[k] + MatrixGraph[k][j].m_time);   //更新
                if (get[j] == 0 && (tem < cost[j]))
                {
                    cost[j] = tem;
                    pre[j] = k;
                }
            }
        }
    }
}

/////////////////////////////////////////////////////////////////

/*时间复杂度分析与输出实现*/
int main()
{
    Timer timer;

    timer.Start();   //计时开始
    ReadCities("cities.csv", city);   //读取城市
    timer.Stop();   //计时结束
    printf("读取城市信息时间为 <%4.2lf> ms\n", timer.ElapsedTime());   //输出时间

    timer.Start();
    ReadRoutes("routes.csv", route);  //读取道路
    timer.Stop();
    printf("读取路线信息时间为 <%4.2lf> ms\n", timer.ElapsedTime());

    timer.Start();
    CreateMatrixGraph();   //创建矩阵
    timer.Stop();
    printf("图的创建时间为 <%4.2lf> ms\n", timer.ElapsedTime());

    //获得起始和结束，此处以从北京到伦敦为例
    string city_from, city_to;
    cout << "起点城市:Beijing\n终点城市:Tokyo\n" << endl;
    city_from = "Beijing";
    city_to = "Tokyo";

    //计算最短路径
    int pre[199] = { 0 };
    float time[199] = { 0 };
    timer.Start();
    int begin = Locate(city_from, city);
    int end = Locate(city_to, city);
    ShortestPath(pre, begin, time);   //计算得最短路径
    timer.Stop();
    printf("计算图的最短路径的时间为 <%4.2lf> ms\n", timer.ElapsedTime());

    cout << city_from << " -> " << city_to << endl;
    cout << "最快到达的最短路径所需时间: " << time[end] << " 小时 " << endl;

    cout << endl << "广度优先遍历:" << endl;
    timer.Start();
    BFSTraverse(begin);   //广度优先遍历Breadth first
    timer.Stop();
    printf("\n图的广度遍历时间为 <%4.2lf> ms\n", timer.ElapsedTime());
    //cout << endl;
    //DFS(city, end);
    //DFSTraverse(city);   //深度优先遍历，另一种方式实现遍历！

    //可视化
    cout << endl;
    int path_ct[199];
    int num = 0;

    timer.Start();
    Dispath(pre, city, begin, end, path_ct, num);   //显示路径函数
    timer.Stop();
    printf("\n显示最短路径时间为 <%4.2lf> ms\n", timer.ElapsedTime());

    timer.Start();
    writeFile(path_ct, num, city);   //输出最短路径到百度地图
    timer.Stop();
    printf("可视化展示时间为 <%4.2lf> ms\n", timer.ElapsedTime());
}