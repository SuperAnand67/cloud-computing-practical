package com.sampleapp.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        String greeting = getGreetingByTime();
        
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Spring Boot App | Cloud Lab</title>
                <style>
                    * {
                        margin: 0;
                        padding: 0;
                        box-sizing: border-box;
                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                    }
                    body {
                        min-height: 100vh;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        background: linear-gradient(135deg, #0f172a 0%, #1e293b 100%);
                        color: #f8fafc;
                    }
                    .card {
                        background: rgba(255, 255, 255, 0.05);
                        backdrop-filter: blur(12px);
                        border: 1px solid rgba(255, 255, 255, 0.1);
                        padding: 2.5rem 3rem;
                        border-radius: 16px;
                        box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.3), 0 10px 10px -5px rgba(0, 0, 0, 0.04);
                        text-align: center;
                        max-width: 480px;
                        width: 90%;
                    }
                    .badge {
                        display: inline-block;
                        padding: 6px 14px;
                        background: rgba(56, 189, 248, 0.15);
                        color: #38bdf8;
                        border-radius: 20px;
                        font-size: 0.85rem;
                        font-weight: 600;
                        letter-spacing: 0.5px;
                        margin-bottom: 1.5rem;
                    }
                    h1 {
                        font-size: 2.2rem;
                        font-weight: 700;
                        margin-bottom: 0.75rem;
                        background: linear-gradient(to right, #38bdf8, #818cf8);
                        -webkit-background-clip: text;
                        -webkit-text-fill-color: transparent;
                    }
                    p {
                        color: #94a3b8;
                        font-size: 1rem;
                        line-height: 1.6;
                        margin-bottom: 2rem;
                    }
                    .btn {
                        background: #38bdf8;
                        color: #0f172a;
                        border: none;
                        padding: 12px 28px;
                        font-size: 0.95rem;
                        font-weight: 600;
                        border-radius: 8px;
                        cursor: pointer;
                        transition: all 0.2s ease-in-out;
                    }
                    .btn:hover {
                        background: #7dd3fc;
                        transform: translateY(-2px);
                        box-shadow: 0 10px 15px -3px rgba(56, 189, 248, 0.3);
                    }
                    .output {
                        margin-top: 1.5rem;
                        padding: 1rem;
                        background: rgba(0, 0, 0, 0.2);
                        border-radius: 8px;
                        font-size: 0.9rem;
                        color: #cbd5e1;
                        display: none;
                    }
                </style>
            </head>
            <body>
                <div class="card">
                    <div class="badge">Render Cloud Deployment</div>
                    <h1>%s, World!</h1>
                    <p>Welcome to your live Spring Boot web application hosted on Render via Docker containerization.</p>
                    <button class="btn" onclick="showStatus()">Check App Status</button>
                    <div id="statusOutput" class="output"></div>
                </div>

                <script>
                    function showStatus() {
                        const out = document.getElementById('statusOutput');
                        out.style.display = 'block';
                        out.innerHTML = '⚡ Status: <strong>ONLINE</strong><br>🚀 Server Time: ' + new Date().toLocaleTimeString();
                    }
                </script>
            </body>
            </html>
            """.formatted(greeting);
    }

    private String getGreetingByTime() {
        int hour = LocalTime.now().getHour();
        if (hour >= 5 && hour < 12) return "Good Morning";
        if (hour >= 12 && hour < 17) return "Good Afternoon";
        if (hour >= 17 && hour < 22) return "Good Evening";
        return "Hello";
    }
}
