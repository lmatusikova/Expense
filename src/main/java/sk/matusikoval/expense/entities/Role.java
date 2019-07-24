package sk.matusikoval.expense.entities;

import javax.persistence.*;

@Entity
public class Role {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idR;
	
	private String authority;

	public Long getIdR() {
		return idR;
	}

	public void setId(Long idR) {
		this.idR = idR;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((idR == null) ? 0 : idR.hashCode());
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
		Role other = (Role) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (idR == null) {
			if (other.idR != null)
				return false;
		} else if (!idR.equals(other.idR))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [idR=" + idR + ", authority=" + authority + "]";
	}
	
	
}
