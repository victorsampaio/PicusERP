/**
 * 
 */
package br.com.picuserp.dao;

import org.springframework.dao.support.DaoSupport;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.picuserp.model.Client;

/**
 * @author Victor Sampaio
 * 
 */
public class ClientDao extends GenericDao<Client, Integer> {

	@SuppressWarnings("unchecked")
	public List<Client> consultClient(Client params) {
		Criteria criteria = createCriteria
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		// Add Restriction
		if ((params.getId() != null) && (params.getId() != 0)) {
			criteria.add(Restrictions.eq("id", params.getId()));
		}
		if ((params.getSocialName() != null)
				&& (params.getSocialName().length() > 0)) {
			criteria.add(Restrictions.like("SocialName",
					params.getSocialName().trim(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if ((params.getFantasyName() != null)
				&& (params.getFantasyName().length() > 0)) {
			criteria.add(Restrictions.like("SocialName",
					params.getFantasyName().trim(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if ((params.getBranchActivity() != null)
				&& (params.getBranchActivity().length() > 0)) {
			criteria.add(Restrictions.like("BranchActivity",
					params.getBranchActivity().trim(), MatchMode.ANYWHERE)
					.ignoreCase());
		}
		if ((params.getCity() != null) && (params.getCity().length() > 0)) {
			criteria.add(Restrictions.like("City", params.getCity().trim(),
					MatchMode.ANYWHERE).ignoreCase());
		}
		if ((params.getUf() != null) && (params.getUf().length() > 0)) {
			criteria.add(Restrictions.like("Uf", params.getUf().trim(),
					MatchMode.ANYWHERE).ignoreCase());
		}

		// More "if"

		// Order by Social Name
		criteria.addOrder(Order.asc("SocialName"));
		// Execute and generate List
		return (List<Client>) criteria.list();
	}

	public List<Client> searchHql(Client params) {

		StringBuffer strHql = new StringBuffer("select " + "from Client client"
				+ "where client.id >0");

		if ((params.getId() != null) && (params.getId() != 0)) {
			strHql.append(" and client.id = ?1");
		}
		if ((params.getSocialName() != null)
				&& (params.getSocialName().length() > 0)) {
			strHql.append(" and lower(client.socialName) like lower(?2)");
		}
		if ((params.getFantasyName() != null)
				&& (params.getFantasyName().length() > 0)) {
			strHql.append(" and lower(client.fantasyName) like lower (?2)");
		}

		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createQuery(strHql.toString());

		if ((params.getId() != null) && (params.getId() != 0)) {
			query.setParameter(1, params.getId());
		}
		if ((params.getSocialName() != null)
				&& (params.getSocialName().length() > 0)) {
			query.setParameter("2", "%" + params.getSocialName() + "%");
		}

		// Execute and generate List
		return (List<Client>) query.getResultList();

	}

}
