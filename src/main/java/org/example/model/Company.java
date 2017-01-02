package org.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.example.model.identification.CompanyIdentification;

@Entity(name="company")
public class Company {
    
    @EmbeddedId
    private CompanyIdentification identification;
   
    
    /** Se remove o mappedBy, serão geradas 3 tabelas:
     * 
     * department (com o id da company a qual pertence
     * 
     * company
     * company_department (tabela de união entre as entidadesdes)
     * 
     * Pela falta do mappedBy, cada lado do relacionamento considera o relacionamento como unidirecional;
     */
    
    @OneToMany(mappedBy="company")
    private List<Department> departaments;
    
   
    @OneToMany
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "name", referencedColumnName="name"),
                    @JoinColumn(name = "cnpj", referencedColumnName="cnpj")},
            inverseJoinColumns=@JoinColumn(name="employee_id"))
    private List<Employee> staff;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "m_name", referencedColumnName="name"),
        @JoinColumn(name = "m_cnpj", referencedColumnName="cnpj")})
    private Company matriz;
    
    
    @Temporal(TemporalType.DATE)
    private Date creation_date;


}
