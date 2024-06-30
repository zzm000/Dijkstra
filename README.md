# Dijkstra

## 利用flask创建 HTTP 接口来调用 Python 实现的迪杰斯特拉算法

```python
@app.route('/dijkstra', methods=['POST'])
def calculate_shortest_path():
    data = request.json
    graph = data['graph']
    start = data['start']
    end = data['end']

    path, distance = dijkstra(graph, start, end)
    return jsonify({'path': path, 'distance': distance})
```

Spring Boot 使用 RestTemplate 发送 HTTP 请求到 Flask API。

## 使用apifox进行POST类型请求发送

![image-20240630220914006](D:\Typora\image-20240630220914006.png)

```
{
    "graph": {
        "A": {"B": 5, "C": 3},
        "B": {"A": 5, "C": 1, "D": 3},
        "C": {"A": 3, "B": 1, "D": 2},
        "D": {"B": 3, "C": 2}
    },
    "start": "A",
    "end": "D"
}
```

## 拓扑图

![image-20240630221234416](D:\Typora\image-20240630221234416.png)

