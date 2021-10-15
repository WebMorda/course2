package pro.sky.course2.сontrollers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.services.ICalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private  final ICalculatorService _calculatorService;

    public CalculatorController(ICalculatorService calculatorService){
        _calculatorService = calculatorService;
    }

    @GetMapping(path = "")
    public String calculator(){
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        int result = _calculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        int result = _calculatorService.minus(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        int result = _calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2){
        float result = _calculatorService.divide(num1, num2);
        return String.format("%d / %d = %.2f", num1, num2, result);
    }
}
