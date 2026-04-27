package com.example.salespossystem.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SimplePlaceholderScreen(title: String) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable fun StockScreen() = SimplePlaceholderScreen("Stock Management")
@Composable fun CustomerSupplierScreen() = SimplePlaceholderScreen("Customers & Suppliers")
@Composable fun DocumentScreen() = SimplePlaceholderScreen("Documents & Invoices")
@Composable fun ExpenseScreen() = SimplePlaceholderScreen("Expense Tracker")
@Composable fun ItemDataEntryScreen() = SimplePlaceholderScreen("Item Data Entry")
