import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api-cheetah/Conteudo")

public class CheetahController {
    private List<Conteudo> conteudos = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public List<Conteudo> getAllConteudos() {
        return conteudos;
    }

    @PostMapping
    public String addConteudo(@RequestBody Conteudo conteudo){
        conteudo.setId(idCounter.incrementAndGet());
        conteudos.add(conteudo);
    }

    @PutMapping("/{id}")
    public String updateConteudo(@PathVariable int id, @RequestBody Conteudo updatedConteudo) {
        for (Conteudo conteudo : conteudos) {
            if (Conteudo.getId() == id) {
                conteudo.setTitulo(updatedConteudo.getTitulo());
                conteudo.setDescricao(updatedConteudo.getDescricao());
                conteudo.setAutor(updatedConteudo.getAutor());
            }
        }
    }

    @DeleteMapping("/{id}")
    public String deleteConteudo(@PathVariable int id){
        for (Conteudo conteudo : conteudos){
            if (conteudo.getId() == id){
                conteudos.remove(conteudo);
            }
        }
    }
}
