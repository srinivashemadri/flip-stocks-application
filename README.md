# Flipstocks Trading Platform

A Java-based stock trading simulation system implementing core financial operations with admin controls and user trading capabilities.

## 🚀 **Project Overview**
**Domain**: Financial Services/Stock Trading Simulation  
**Purpose**: Simulate a marketplace where:
- Admins control stock listings and market time progression
- Users trade stocks using wallet balances
- Real-time portfolio tracking with return rate calculations

### Key Features
- Admin-controlled stock market lifecycle
- User registration and trading
- Portfolio valuation with dynamic return rates
- Time-based stock price fluctuations
- Authentication-protected admin operations

## ⚙️ **Technical Highlights**
- **Language**: Java 8+
- **Patterns**: Singleton, Command, Factory
- **SOLID Principles**: Full compliance
- **Security**: Env-var based admin credentials
- **Storage**: In-memory data management

## ▶️ **How to Run**
### Prerequisites
- JDK 8+ installed
- Environment variables set:
  ```bash
  export ADMIN_USERNAME="admin"
  export ADMIN_PASSWORD="admin"