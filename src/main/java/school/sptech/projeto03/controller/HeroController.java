package school.sptech.projeto03.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.sptech.projeto03.entity.Hero;

@RestController
@RequestMapping("/heroes")
public class HeroController {
    
    // attributes
    private List<Hero> heroes = new ArrayList<Hero>();

    // methods
    private boolean isValidId(int id) {
        return Objects.nonNull(id) && id >= 0 && id < heroes.size();
    }

    // endpoints 

    // GET
    @GetMapping
    public List<Hero> getHeroes() {
        return heroes;
    }

    @GetMapping("/{index}")
    public Hero getHero(@PathVariable int index) {
        if (isValidId(index)) {
            return heroes.get(index);
        }
        return null;
    }

    // POST
    @PostMapping
    public Hero postHero(@RequestBody Hero hero) { 
        hero.setId(heroes.size());
        heroes.add(hero);
        return hero;
    }

    // PUT
    @PutMapping("/{id}")
    public Hero putHero(@RequestBody Hero hero, @PathVariable int id) {
        if (isValidId(id)) {
            heroes.set(id, hero);
            return heroes.get(id);
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Hero deleteHero(@PathVariable int id) {
        if (isValidId(id)) {
            Hero hero = heroes.get(id);
            heroes.remove(id);
            return hero;
        }
        return null;
    }
}
