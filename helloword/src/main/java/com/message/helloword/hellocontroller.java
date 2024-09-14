package com.message.helloword;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class hellocontroller {

    //Creacion de lista para elementos
    private List<String>items = new ArrayList<String>();

    public hellocontroller(){
        items.add("Colombia");
        items.add("Brasil");
        items.add("Argentina");
        items.add("Peru");
        items.add("Chile");
        items.add("Venezuela");
        items.add("Boliva");

    }
    //creacion de elementos
    @PostMapping
    public String addItem(@RequestBody String newItem){
        items.add(newItem);
        return "Item insertado con Exito !!";
    }

    //consulta de elementos, todos los items
    @GetMapping
    public Map<String, Object> getAllItems() {
        Map<String, Object> response = new HashMap<>();
        response.put("items", items);
        response.put("count", items.size());
        return response;
    }

    //consulta de elementos, item por posicion
    @GetMapping("/{index}")
    public String getItem(@PathVariable int index){
        if(index >= 0 && index < items.size()){
            return items.get(index);
        }else{
            return "pais no encontrado! ";
        }
    }


    //Actualizar elementos
    @PutMapping("/{index}")
    public String modifyItem(@PathVariable int index, @RequestBody String newItem){
        if(index >= 0 && index < items.size()){
            items.set(index,newItem);
            return "Pais modificado con Exito !!";
        }else{
            return "Pais no encontrado! ";
        }
    }


    //Eliminacion de elementos
    @DeleteMapping("/{index}")
        public String deleteItem(@PathVariable int index){
            if(index >= 0 && index < items.size()){
                items.remove(index);
                return "Pais eliminado con Exito !!";
            }else {
                return "Pais no encontrado! ";
            }

        }

}
