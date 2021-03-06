package be.abis.casebce.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.abis.casebce.model.Activity;

/**
 * Session Bean implementation class ActivitySession
 */
@Stateless(name = "ActivitySession")
public class ActivitySession implements ActivitySessionRemote {

	@PersistenceContext(unitName = "CaseBCE")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ActivitySession() {

	}

	@Override
	public List<Activity> getActivities(int performerId) {
		List<Activity> performerActivities = em
				.createQuery("Select a From Activity a Where a.performer.id = :performerId", Activity.class)
				.setParameter("performerId", performerId).getResultList();
		return performerActivities;
	}

	@Override
	public void updateActivity(Activity activity) throws Exception {
		if (activity.getStart().isAfter(activity.getEnd())) {
			throw new Exception("Activity cannot be closed before it starts");
		}
		em.merge(activity);
	}

	@Override
	public void createActivity(Activity activity) throws Exception {
		if (activity.getStart().isAfter(activity.getEnd())) {
			throw new Exception("Activity cannot be closed before it starts");
		}
		em.persist(activity);
	}

	@Override
	public Activity reuploadActivity(int activityId) {
		Activity activity = em.find(Activity.class, activityId);
		return activity;
	}

}
