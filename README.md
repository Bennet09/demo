# Demo Kubernetes Application

[![Kubernetes](https://img.shields.io/badge/Kubernetes-Ready-blue)](https://kubernetes.io/)
[![Argo CD](https://img.shields.io/badge/ArgoCD-GitOps-orange)](https://argo-cd.readthedocs.io/)

## Overview
This project demonstrates a full **GitOps workflow** using **Kubernetes** and **Argo CD**. It includes a **Spring Boot** application with a **PostgreSQL** database, deployed using Kubernetes manifests stored in Git. Scheduled tasks are managed via **CronJobs**.

## Features
- Spring Boot demo application
- PostgreSQL database with persistent storage
- Kubernetes Deployment, Service, and CronJob manifests
- Argo CD for automated deployment
- Database testing from pods

## Prerequisites
- Kubernetes cluster (Minikube, Kind, or cloud provider)
- kubectl installed
- Argo CD installed in the cluster
- Git

## Getting Started

1. **Clone the repository**
```bash
git clone https://github.com/Bennet09/demo.git
cd demo
