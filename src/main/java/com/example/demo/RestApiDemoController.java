package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
class RestApiDemoController {

    /* private List<Coffee> coffees
    = new ArrayList<>();*/
    private final CoffeeRepository coffeeRepository;

    public RestApiDemoController(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    //@RequestMapping(value = "/coffee", method = RequestMethod.GET)
    //@GetMapping("/coffees")
    @GetMapping()
    Iterable<Coffee> getCoffees(){
        return coffeeRepository.findAll();
    }


    //@GetMapping("/coffees/{id}")
    /*Optional<Coffee> getCoffeeById(@PathVariable String id){
        for(Coffee c :coffees){
            if (c.getId().equals(id)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }*/
    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        return coffeeRepository.findById(id);
    }


    /*Coffee postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return coffee;
    }*/
    @PostMapping()
    Coffee postCoffee(@RequestBody Coffee coffee){
        return coffeeRepository.save(coffee);
    }


    /* ResponseEntity<Coffee> putCoffee(@PathVariable String id,@RequestBody Coffee coffee){
        int coffeeIndex = -1;

        for (Coffee c: coffees){
            if (c.getId().equals(id)){
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }

        return (coffeeIndex == -1) ?
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }*/
    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
        return (coffeeRepository.existsById(id)) ?
                new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
                : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
    }


    /*void deleteCoffee(@PathVariable String id){
        coffees.removeIf(c -> c.getId().equals(id));
    }*/
    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id){
        coffeeRepository.deleteById(id);
    }

}
