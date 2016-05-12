package br.upe.pegaporra.ui;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upe.pegaporra.entidades.Agendamento;
import br.upe.pegaporra.entidades.Conta;
import br.upe.pegaporra.entidades.Post;
import br.upe.pegaporra.entidades.Usuario;
import br.upe.pegaporra.fachada.Fachada;

@RestController
@RequestMapping("/safadao")
public class WSController {
	
	@Autowired
	private Fachada fachada;
	
	//Metodos Usuario
	
	@RequestMapping(value="/usuario/listar", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> listarTodosUsuarios() {
		return this.fachada.listarUsuario();
	}
	
	@RequestMapping(value="/usuario/buscarCpf")
	public ResponseEntity<?> buscarCpf(String cpf) {
		try {
			this.fachada.buscarCpf(cpf);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/usuario/add")
	public ResponseEntity<?> adicionarUsuario(Usuario u) {
		try {
			this.fachada.adcionar(u);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/usuario/atualizar")
	public ResponseEntity<?> atualizarUsuario(Usuario u) {
		try {
			this.fachada.atualizar(u);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/usuario/remover")
	public ResponseEntity<?> removerUsuario(String cpf) {
		try {
			this.fachada.removerUsuario(cpf);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	//Metodos Conta
	
	@RequestMapping(value="/conta/listar", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Conta> listarTodasContas() {
		return this.fachada.listarConta();
	}
	
	@RequestMapping(value="/conta/add")
	public ResponseEntity<?> adcionarConta(Conta c) {
		try {
			this.fachada.adcionar(c);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/conta/atualizar")
	public ResponseEntity<?> atualizarConta(Conta c) {
		try {
			this.fachada.atualizar(c);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value="/conta/remover")
	public ResponseEntity<?> removerConta(String email) {
		try {
			this.fachada.removerConta(email);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/conta/buscarEmail")
	public ResponseEntity<?> buscarEmail(String email) {
		try {
			this.fachada.buscarEmail(email);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	//Metodos Post
	
	@RequestMapping(value="/post/add")
	public ResponseEntity<?> adcionarPost(Post p) {
		try {
			this.fachada.adcionar(p);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/post/atualizar")
	public ResponseEntity<?> atualizarPost(Post p) {
		try {
			this.fachada.atualizar(p);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/post/remover")
	public ResponseEntity<?> removerPost(Long id) {
		try {
			this.fachada.removerPost(id);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/post/listar", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Post> listarTodosPosts() {
		return this.fachada.listarPost();
	}
	
	@RequestMapping(value="/post/buscarId")
	public ResponseEntity<?> buscarIdPost(Long id) {
		try {
			this.fachada.buscarIdPost(id);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	//Metodos Agendamento
	
	@RequestMapping(value="/agendamento/add")
	public ResponseEntity<?> adcionarAgendamento(Agendamento a) {
		try {
			this.fachada.adcionar(a);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/agendamento/atualizar")
	public ResponseEntity<?> atualizarAgendamento(Agendamento a) {
		try {
			this.fachada.atualizar(a);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/agendamento/remover")
	public ResponseEntity<?> removerAgendamento(Long id) {
		try {
			this.fachada.removerAgendamento(id);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/agendamento/listar", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Agendamento> listarTodosAgendamentos() {
		return this.fachada.listarAgendamento();
	}
	
	@RequestMapping(value="/agendamento/buscarData")
	public ResponseEntity<?> buscarData(Date data) {
		try {
			Agendamento a = this.fachada.buscarData(data);
			return new ResponseEntity<Agendamento>(a, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value="/agendamento/buscarHora")
	public ResponseEntity<?> buscarHora(Date hora) {
		try {
			this.fachada.buscarHora(hora);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/agendamento/buscarId")
	public ResponseEntity<?> buscarIdAgendamento(Long id) {
		try {
			this.fachada.buscarIdAgendamento(id);
		} catch(Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
