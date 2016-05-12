package br.upe.pegaporra.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Conta {

	private String emailConta;
	private String senhaConta;
	private List<Post> posts;
	private Long id;
	private Usuario usuario;
	
	public Conta() {
		
	}

	public Conta(String emailConta, String senhaConta, List<Post> posts, Long id, Usuario usuario) {
		super();
		this.emailConta = emailConta;
		this.senhaConta = senhaConta;
		this.posts = posts;
		this.id = id;
		this.usuario = usuario;
	}

	public String getEmailConta() {
		return emailConta;
	}

	public void setEmailConta(String emailConta) {
		this.emailConta = emailConta;
	}

	public String getSenhaConta() {
		return senhaConta;
	}

	public void setSenhaConta(String senhaConta) {
		this.senhaConta = senhaConta;
	}

	@OneToMany(mappedBy = "conta")
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne()
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailConta == null) ? 0 : emailConta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((senhaConta == null) ? 0 : senhaConta.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (emailConta == null) {
			if (other.emailConta != null)
				return false;
		} else if (!emailConta.equals(other.emailConta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (senhaConta == null) {
			if (other.senhaConta != null)
				return false;
		} else if (!senhaConta.equals(other.senhaConta))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta [emailConta=" + emailConta + ", senhaConta=" + senhaConta +  "posts=" + posts + ", id=" + id + ", usuario=" + usuario + "]";
	}

	
	
	
}
