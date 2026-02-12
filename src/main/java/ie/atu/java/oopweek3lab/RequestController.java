package ie.atu.java.oopweek3lab;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RequestController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/greet/{name}")
    public String greetByName(@PathVariable String name)
    {
        return "Hello "+name;
    }
    @GetMapping("/details")
    public String details(@RequestParam String name, @RequestParam Integer age){
        return "Hello "+name+" "+age;
    }

    @GetMapping("/person")
    public Person getPerson(){
    Person person = new Person("Oisin", 21);
    return person;
    }

    @GetMapping("/calculate")
    public Integer Calculate(@RequestParam Integer num1, @RequestParam Integer num2, @RequestParam String operation){
    switch (operation){
        case "add":
            return num1 += num2;

            case "subtract":
                return num1 -= num2;

                case "multiply":
                    return num1*=num2;

                    case "divide":
                        if(num2==0){
                            throw new ArithmeticException("Division by zero");
                        }
                        return num1/=num2;

                        default:
                            throw new IllegalArgumentException("Invalid operation: " + operation);

    }
    }

}
