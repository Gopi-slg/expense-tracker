package com.example.Expense_Tracker.controller;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable String id) {
        return service.getExpenseById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable String id) {
        service.deleteExpense(id);
        return "Deleted successfully";
    }
    @DeleteMapping
    public String deleteExpenses(){
        service.deleteExpenses();
        return "Cleared data Successfully";
    }
}