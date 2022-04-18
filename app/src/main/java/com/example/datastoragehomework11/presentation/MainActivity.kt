package com.example.datastoragehomework11.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.datastoragehomework11.R
import com.example.datastoragehomework11.domain.Employee
import com.example.datastoragehomework11.domain.Position

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val positionList = listOf(Position("Java-разработчик"),
            Position("Тестировщик"),
            Position("Android-разработчик"),
            Position("Дизайнер"),
            Position("Проджект-менеджер"),
            Position("IOS-разработчик"),
            Position("Директор"),
            Position("Розовый слон"),
            Position("Тимлид"),
            Position("Технический писатель"),
            Position("Позиция Т"),
            Position("Позиция В"),
            Position("Позиция З"),
            Position("Позиция Ы")
        )

        for (i in positionList) {
            viewModel.addPosition(i)
        }


        val employeesList = listOf(Employee("Вася", 32, 4, Position("Java-разработчик")),
            Employee("Вася", 24, 89, Position("Дизайнер")),
            Employee("Маша", 67, 5, Position("Розовый слон")),
            Employee("Петя", 45, 20, Position("Java-разработчик")),
            Employee("Жучок", 28, 7, Position("Тестировщик")),
            Employee("Даня", 20, 3, Position("Директор")),
            Employee("Люба", 36, 8, Position("Android-разработчик")),
            Employee("Степа", 24, 89, Position("Дизайнер")),
            Employee("Жора", 12, 28, Position("Розовый слон")),
            Employee("Петя", 45, 20, Position("Java-разработчик")),
            Employee("Иван", 28, 7, Position("Тимлид")),
            Employee("Паша", 20, 3, Position("Технический писатель")),
            Employee("Вика", 36, 8, Position("Android-разработчик"))
        )

        for (i in employeesList) {
            viewModel.addEmployee(i)
        }
    }
}