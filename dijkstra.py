import heapq
from flask import Flask, request, jsonify

app = Flask(__name__)

def dijkstra(graph, start, end):
    queue = [(0, start)]
    distances = {vertex: float('infinity') for vertex in graph}
    distances[start] = 0
    predecessors = {vertex: None for vertex in graph}

    while queue:
        current_distance, current_vertex = heapq.heappop(queue)

        if current_distance > distances[current_vertex]:
            continue

        for neighbor, weight in graph[current_vertex].items():
            distance = current_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                predecessors[neighbor] = current_vertex
                heapq.heappush(queue, (distance, neighbor))

    path, current = [], end
    while current is not None:
        path.append(current)
        current = predecessors[current]
    path.reverse()

    return path, distances[end]

@app.route('/dijkstra', methods=['POST'])
def calculate_shortest_path():
    data = request.json
    graph = data['graph']
    start = data['start']
    end = data['end']

    path, distance = dijkstra(graph, start, end)
    return jsonify({'path': path, 'distance': distance})

if __name__ == '__main__':
    app.run(debug=True)
