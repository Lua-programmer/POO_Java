package application;

import entities.Employee;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

public class ProgramaExercicioEmployee {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        PrintStream show = System.out;
        Scanner sc = new Scanner(System.in);

        show.print("How many employees will be registered? ");
        int N = sc.nextInt();

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            show.println();
            show.printf("Employee: #%d:\n", i + 1);
            show.print("Id: ");
            Integer id = sc.nextInt();
            show.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            show.print("Salary: R$ ");
            Double salary = sc.nextDouble();

            Employee employee = new Employee(id, name, salary); //INSTANCIA UM FUNCIONARIO DO TIPO FUNCIONARIO

            //INSERINDO(adicionando) ESSE FUNCIONARIO CRIADO NA LISTA
            list.add(employee);
        }

        show.println();
        show.print("Enter the employee id that will have salary increase: ");
        int idSalary = sc.nextInt();

        //Integer position = positionIdInList(list, idSalary);
                          //transforma a lista numa stream, chamando a funcao filter que vai atender ao predicado, e pega o primeiro
        Employee employee = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        if (employee == null) {
            show.println();
            show.print("Este Id não existe!");
        } else {
            show.print("Entre com o valor da porcentagem: ");
            Double percentage = sc.nextDouble();
            //list.get(position).increaseSalary(percentage);
            employee.increaseSalary(percentage);
        }

        show.println();
        show.println("Lista de funcionários: ");

        for (Employee e: list){
            show.println(e);
        }


        sc.close();
    }

    //AQUI É OUTRA VARIAVEL LIST, POIS ESTA FORA DO ESCOPO
    public static Integer positionIdInList(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) return i;
        }
        return  null;
    }
}
