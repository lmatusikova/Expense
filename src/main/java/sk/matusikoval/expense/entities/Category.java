package sk.matusikoval.expense.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idC;

    private String description;
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "category_expense", joinColumns = {@JoinColumn(name = "idC")}, inverseJoinColumns = {@JoinColumn(name = "idE")})
    @JsonManagedReference
    private Set<Expense> expenses = new HashSet<Expense>();
    
    @ManyToOne
    private User user;

    public Long getIdC() {
        return idC;
    }

    public void setIdC(Long idC) {
        this.idC = idC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((expenses == null) ? 0 : expenses.hashCode());
		result = prime * result + ((idC == null) ? 0 : idC.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Category other = (Category) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expenses == null) {
			if (other.expenses != null)
				return false;
		} else if (!expenses.equals(other.expenses))
			return false;
		if (idC == null) {
			if (other.idC != null)
				return false;
		} else if (!idC.equals(other.idC))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [idC=" + idC + ", description=" + description + ", name=" + name + ", expenses=" + expenses
				+ ", user=" + user + "]";
	}


    
}
