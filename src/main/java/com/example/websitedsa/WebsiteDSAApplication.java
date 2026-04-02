package com.example.websitedsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class WebsiteDSAApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteDSAApplication.class, args);
    }

    private Map<String, VideoInfo> getAllDataStructures() {
        Map<String, VideoInfo> videos = new LinkedHashMap<>();

        // Original 7 videos
        videos.put("stack", new VideoInfo("Stack", "Stack.mp4",
                "Last In First Out (LIFO) data structure. Elements are added and removed from the top.", "📚"));
        videos.put("queue", new VideoInfo("Queue", "Queue.mp4",
                "First In First Out (FIFO) data structure. Elements are added at rear and removed from front.", "🎫"));
        videos.put("singly-linked-list", new VideoInfo("Singly Linked List", "Singly_Linked_List.mp4",
                "Linear data structure with nodes pointing to the next node in sequence.", "🔗"));
        videos.put("doubly-linked-list", new VideoInfo("Doubly Linked List", "Doubly_Linked_List.mp4",
                "Each node has pointers to both previous and next nodes for bidirectional traversal.", "⇄"));
        videos.put("singly-circular-linked-list", new VideoInfo("Singly Circular Linked List", "Singly_Circular_Linked_List.mp4",
                "The last node points back to the first node, forming a circular structure.", "🔄"));
        videos.put("matrix", new VideoInfo("Matrix", "MATRIX.mp4",
                "Two-dimensional array structure for storing data in rows and columns.", "⊞"));
        videos.put("dictionary-and-tuples", new VideoInfo("Dictionary & Tuples", "Dictionary_and_tuples.mp4",
                "Key-value pairs (Dictionary) and immutable ordered sequences (Tuples).", "📖"));
        videos.put("array", new VideoInfo("Array", "HOW ARRAY WORKS.mp4",
                "Fixed-size sequential collection of elements stored in contiguous memory locations.", "🔢"));
        videos.put("list", new VideoInfo("List", "HOW LIST WORK.mp4",
                "Dynamic-size sequential collection that can grow or shrink during runtime.", "📝"));
        videos.put("doubly-circular-linked-list", new VideoInfo("Doubly Circular Linked List", "Doublyt CIrcular Linked List.mp4",
                "Doubly linked list where last node points to first and first points to last.", "↻"));

        return videos;
    }

    private Map<String, VideoInfo> getAllAlgorithms() {
        Map<String, VideoInfo> videos = new LinkedHashMap<>();

        videos.put("bubble-sort", new VideoInfo("Bubble Sort", "Bubble Sort.mp4",
                "Repeatedly swaps adjacent elements if they are in the wrong order until the list is sorted.", "🫧"));
        videos.put("selection-sort", new VideoInfo("Selection Sort", "SELECTION SORT.mp4",
                "Finds the minimum element from the unsorted portion and places it at the beginning each pass.", "🎯"));
        videos.put("insertion-sort", new VideoInfo("Insertion Sort", "Insertion Sort.mp4",
                "Builds a sorted array one element at a time by inserting each element into its correct position.", "🃏"));
        videos.put("linear-search", new VideoInfo("Linear Search", "LINEAR SEARCH.mp4",
                "Sequentially checks each element in a list until the target value is found or the list ends.", "🔍"));
        videos.put("hash-tables", new VideoInfo("Hash Tables", "Hash Tables.mp4",
                "Data structure that maps keys to values using a hash function for fast lookups.", "🗂️"));
        videos.put("trees", new VideoInfo("Trees", "Trees.mp4",
                "Hierarchical data structure with a root node and subtrees of children, forming a parent-child relationship.", "🌳"));
        videos.put("graph", new VideoInfo("Graph", "Graph.mp4",
                "Non-linear data structure consisting of vertices (nodes) connected by edges.", "🕸️"));
        videos.put("breadth-first-search", new VideoInfo("Breadth First Search", "Breadth First Search.mp4",
                "Traversal algorithm that explores all neighbors at the current depth before moving to the next level.", "🌊"));
        videos.put("depth-first-search", new VideoInfo("Depth First Search", "Depth First Search.mp4",
                "Traversal algorithm that explores as far as possible along each branch before backtracking.", "🏔️"));
        videos.put("binary-search", new VideoInfo("Binary Search", "BINARY SEARCH.mp4",
                "Efficient search algorithm that repeatedly divides a sorted array in half to locate a target value.", "🔎"));
        videos.put("heaps", new VideoInfo("Heaps", "HEaps.mp4",
                "Tree-based data structure satisfying the heap property, used in priority queues and heap sort.", "⛰️"));

        return videos;
    }

    @GetMapping("/")
    public String index(Model model) {
        Map<String, VideoInfo> allStructures = getAllDataStructures();
        Map<String, VideoInfo> allAlgorithms = getAllAlgorithms();
        VideoInfo defaultVideo = allStructures.get("stack");

        model.addAttribute("structures", allStructures);
        model.addAttribute("algorithms", allAlgorithms);
        model.addAttribute("currentDs", "stack");
        model.addAttribute("dsName", defaultVideo.title);
        model.addAttribute("videoFile", defaultVideo.filename);
        model.addAttribute("description", defaultVideo.description);
        model.addAttribute("icon", defaultVideo.icon);

        return "index";
    }

    @GetMapping("/ds/{name}")
    public String viewStructure(@PathVariable String name, Model model) {
        Map<String, VideoInfo> allStructures = getAllDataStructures();
        Map<String, VideoInfo> allAlgorithms = getAllAlgorithms();

        VideoInfo currentVideo = allStructures.containsKey(name)
                ? allStructures.get(name)
                : allAlgorithms.getOrDefault(name, allStructures.get("stack"));

        model.addAttribute("structures", allStructures);
        model.addAttribute("algorithms", allAlgorithms);
        model.addAttribute("currentDs", name);
        model.addAttribute("dsName", currentVideo.title);
        model.addAttribute("videoFile", currentVideo.filename);
        model.addAttribute("description", currentVideo.description);
        model.addAttribute("icon", currentVideo.icon);

        return "index";
    }

    public static class VideoInfo {
        public String title;
        public String filename;
        public String description;
        public String icon;

        public VideoInfo(String title, String filename, String description, String icon) {
            this.title = title;
            this.filename = filename;
            this.description = description;
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public String getFilename() {
            return filename;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }
}