package services;

import entities.Contract;
import entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {
    //declara com o tipo da interface
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicQuota = contract.getTotalValue() / months;
        //200.00
        for (int i = 1; i <= months; i++) {
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
            //202.00
            double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            //206.04

            Date dueDate = addMonths(contract.getDate(), i);
            contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }
    }

    //método para adicionar meses a uma data
    private Date addMonths(Date date, int N) {
        Calendar calendar = Calendar.getInstance(); //pega uma instancia do calendario
        calendar.setTime(date); //setar a data
        calendar.add(Calendar.MONTH, N); //adiciona n meses a um calendario
        return calendar.getTime(); //volta a valer um date
    }

}
