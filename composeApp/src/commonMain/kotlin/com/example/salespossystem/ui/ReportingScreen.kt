package com.example.salespossystem.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.salespossystem.viewmodel.SalesViewModel

@Composable
fun ReportingScreen(viewModel: SalesViewModel) {
    val totalSales = viewModel.allInvoices.sumOf { it.totalAmount }
    val totalExpenses = viewModel.expenses.sumOf { it.amount }
    val netProfit = totalSales - totalExpenses

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SimpleModuleHeader("Business Reports", Icons.Default.BarChart)

        LazyVerticalGrid(
            columns = GridCells.Adaptive(300.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { 
                ReportStatCard(
                    "Total Revenue", 
                    "${viewModel.currencySymbol}${totalSales}", 
                    Color(0xFF4CAF50)
                ) 
            }
            item { 
                ReportStatCard(
                    "Total Expenses", 
                    "${viewModel.currencySymbol}${totalExpenses}", 
                    Color(0xFFF44336)
                ) 
            }
            item { 
                ReportStatCard(
                    "Net Profit", 
                    "${viewModel.currencySymbol}${netProfit}", 
                    if (netProfit >= 0) Color(0xFF2196F3) else Color(0xFFE91E63)
                ) 
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        
        Text("Transaction Summary", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Total Invoices:", color = Color.Gray)
                    Text("${viewModel.allInvoices.size}", fontWeight = FontWeight.Bold)
                }
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Total Expenses Recorded:", color = Color.Gray)
                    Text("${viewModel.expenses.size}", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ReportStatCard(label: String, value: String, color: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(Modifier.padding(24.dp)) {
            Text(label, color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(value, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = color)
        }
    }
}
