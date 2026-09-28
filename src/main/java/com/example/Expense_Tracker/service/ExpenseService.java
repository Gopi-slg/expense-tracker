package com.example.Expense_Tracker.service;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Expense getExpenseById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteExpense(String id) {
        repository.deleteById(id);
    }

    public void deleteExpenses() {
        repository.deleteAll();
    }
}