# Student Management System API Testing Guide

**Base URL:** `http://localhost:8080/api/students`

---

## I. Standard CRUD Operations

| # | Operation | Method | URL Example | Body Example (JSON) | Expected Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **1.** | **CREATE** | `POST` | `/api/students` | `{"name": "Alex Johnson", "major": "Computer Science"}` | `201 Created` |
| **2.** | **READ ALL** | `GET` | `/api/students` | (None) | `200 OK` |
| **3.** | **READ BY ID** | `GET` | `/api/students/1` | (None) | `200 OK` (Found) / `404 Not Found` (Missing) |
| **4.** | **UPDATE** | `PUT` | `/api/students/1` | `{"name": "Alex J. Updated", "major": "Data Science"}` | `200 OK` ("Student details updated successfully!") / `404 Not Found` (Missing ID) |
| **5.** | **DELETE** | `DELETE` | `/api/students/1` | (None) | `200 OK` ("Student deleted successfully!") / `404 Not Found` (Missing ID, due to updated logic) |

---

## II. Complex Query Endpoints

These endpoints test the custom logic implemented in the repository (Query Methods, JPQL, Native SQL).

| # | Query Type | Method | URL Example (with Query Params) | Expected Status |
| :--- | :--- | :--- | :--- | :--- |
| **6.** | **Find By Major** (Query Method) | `GET` | `/api/students/search/major?major=Physics` | `200 OK` |
| **7.** | **Find Top Roll Nos** (JPQL Query) | `GET` | `/api/students/search/honors?maxRollNo=10` | `200 OK` |
| **8.** | **Search By Name** (Native Query) | `GET` | `/api/students/search/name?nameKeyword=Al` | `200 OK` |
