# Retail Insights – Stock Health Report
## Project Description
A regional supermarket chain facing inventory problems
- Overstocking unsold items 
- Running out of high-demand products

This project provides a **data-driven Stock Health Report** using SQL to help optimize inventory decisions.

---
##  Database Schema

### 1. Categories
Stores product categories.
- `category_id` (PK)
- `category_name`

### 2. Products
Stores product details.
- `product_id` (PK)
- `product_name`
- `product_price`
- `expiry_date`
- `stock_count`
- `category_id` (FK)

### 3. SalesTransactions
Tracks product sales.
- `t_id` (PK)
- `product_id` (FK)
- `purchase_date`
- `quantity`

---

## Key Reports
### 1. Expiring Soon Products
Find products:
- Expiring within next 7 days
- Stock count greater than 50

### 2. Dead stock analysis
Find products:
- No sales in last 60 days

### 3.Revenue contribution
Find which category generated the most revenue last month.

