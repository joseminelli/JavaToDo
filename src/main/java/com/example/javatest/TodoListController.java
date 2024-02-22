
package com.example.javatest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TodoListController {
    @FXML
    private TextField taskInput;
    @FXML
    private ListView<TodoItem> todoListView;

    private ObservableList<TodoItem> todoItems;

    public void initialize() {
        todoItems = FXCollections.observableArrayList();
        todoListView.setItems(todoItems);
    }

    @FXML
    private void addTask() {
        String taskText = taskInput.getText().trim();
        if (!taskText.isEmpty()) {
            TodoItem newItem = new TodoItem(taskText);
            todoItems.add(newItem);
            taskInput.clear();
        }
    }

    @FXML
    private void toggleCompleted() {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItem.setCompleted(!selectedItem.isCompleted());
            todoListView.refresh();
        }
    }

    @FXML
    private void removeTask() {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            todoItems.remove(selectedItem);
        }
    }
}
