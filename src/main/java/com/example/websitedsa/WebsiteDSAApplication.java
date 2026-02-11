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

        return videos;
    }

    @GetMapping("/")
    public String index(Model model) {
        Map<String, VideoInfo> allStructures = getAllDataStructures();
        VideoInfo defaultVideo = allStructures.get("stack");

        model.addAttribute("structures", allStructures);
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
        VideoInfo currentVideo = allStructures.getOrDefault(name, allStructures.get("stack"));

        model.addAttribute("structures", allStructures);
        model.addAttribute("currentDs", name);
        model.addAttribute("dsName", currentVideo.title);
        model.addAttribute("videoFile", currentVideo.filename);
        model.addAttribute("description", currentVideo.description);
        model.addAttribute("icon", currentVideo.icon);

        return "index";
    }

    // FIXED: Added public fields and getters
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

        // Getters for Thymeleaf access
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