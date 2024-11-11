Optimal Path Finder: Coppell to Midlothian, Texas

This project utilizes Dijkstra’s Algorithm to find the shortest path between Coppell and Midlothian, Texas, optimizing travel routes by calculating the most efficient path based on weighted distances.

Table of Contents

	•	Introduction
	•	Features
	•	Installation
	•	Usage
	•	Example
	•	Contributing
	•	License

Introduction

This repository demonstrates the use of Dijkstra’s Algorithm to solve real-world routing problems. The goal is to determine the optimal path between two locations while considering various route constraints, such as distance and time.

Features

	•	Shortest Path Calculation: Implements Dijkstra’s Algorithm for optimal route planning.
	•	Customizable Graph: Modify nodes and edge weights to represent different routes and distances.
	•	Detailed Output: Provides step-by-step instructions and visualizations of the optimal path.

Installation

To get started, clone this repository and install the required dependencies.

git clone https://github.com/yourusername/optimal-path-finder.git
cd optimal-path-finder
pip install -r requirements.txt

Usage

	1.	Define your graph with nodes (locations) and edges (routes with weights).
	2.	Run the script to calculate the shortest path.

python optimal_path.py

	3.	View the optimal route and distance in the output.

Example

Here’s a simple example of how the graph is defined and used:

graph = {
    'Coppell': {'Irving': 10, 'Carrollton': 8},
    'Irving': {'Dallas': 15},
    'Carrollton': {'Dallas': 12, 'Midlothian': 20},
    'Dallas': {'Midlothian': 10},
    'Midlothian': {}
}

start = 'Coppell'
end = 'Midlothian'

optimal_path, distance = dijkstra(graph, start, end)
print(f"The optimal path is: {optimal_path} with a total distance of {distance} units.")

Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue to suggest improvements or new features.

Happy pathfinding! 🚀
