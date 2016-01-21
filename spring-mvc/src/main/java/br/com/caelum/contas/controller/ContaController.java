package br.com.caelum.contas.controller;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by vanessa on 23/12/15.
 */
@Controller
public class ContaController {

    @Autowired
    private ContaDAO contaDAO;

    @RequestMapping("/form")
    public String formulario(Model model){
        model.addAttribute("conta", new Conta());
        return "conta/formulario";
    }

    @RequestMapping("/adicionarContas")
    public String adiciona(@Valid Conta conta, BindingResult result){
        if(result.hasErrors()){
            return "conta/formulario";
        }
        if(conta.getId() == null)   contaDAO.adiciona(conta);
        else    contaDAO.altera(conta);
        System.out.println(conta.getDescricao());
        return "redirect:listaContas";
    }

    @RequestMapping("/listaContas")
    public String lista(Model mv){
        List<Conta> contas = contaDAO.lista();
        mv.addAttribute("contas", contas);
        return "conta/lista";
    }

    @RequestMapping("/removeConta")
    public String removeConta(Conta conta){
        contaDAO.remove(conta);
        System.out.println(conta.getDescricao());
        return "redirect:listaContas";
    }
    @RequestMapping("/editarConta")
    public String editar(Conta conta, Model mv){
        mv.addAttribute("conta", contaDAO.buscaPorId(conta.getId()));
        return "conta/formulario";

    }
}
