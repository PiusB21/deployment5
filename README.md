# deployment5
CS 421 - CAPSTONE PROJECT

#  Monitoring App

A full-stack application for monitoring multiple frontend nodes, including:

- Periodic HTTP/HTTPS health checks
- Alert system via email (on repeated downtime)
- Color-coded frontend dashboard showing status, latency, SSL/domain countdown
- Deployed via Docker and Docker Compose, scalable with load balancer

---

## Tech Stack

- **Backend**: Spring Boot 3.5.x
- **Frontend**: Vue.js 3 + Chart.js (or similar)
- **Database**: PostgreSQL
- **Alerts**: Email (SMTP)
- **Deployment**: Docker, Docker Compose, NGINX, AWS Free Tier

---

## ⚙️ Features

### ✅ Backend

- CRUD for Targets `/targets`
- Check status `/status/{id}`
- View status history `/history/{id}`
- Manage alert rules `/alerts`
- Periodic health checks (every 5 min)
- Email alerts on 2+ consecutive downtimes

### ✅ Frontend

- Lists all monitored nodes
- Shows current status (healthy/warning/critical)
- Displays latency, response time, and countdowns for SSL/Domain expiry
- Indicates which frontend node is responding (via instance name)



## 🐳 Docker Setup
Docker files are included in the deployment5-frontend and deployment5-backend directories respectively 
and the docker-compose.yml file is included in the deployment5-backend directory

