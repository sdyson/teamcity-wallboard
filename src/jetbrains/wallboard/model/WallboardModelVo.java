/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.model;

import java.util.List;

/**
 *
 * @author Simon Dyson
 */
public class WallboardModelVo implements WallboardModel
{
    private List<ProjectModel> projects;

// --------------------------- CONSTRUCTORS ---------------------------

    public WallboardModelVo()
    {
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public void setProjects(List<ProjectModel> projects)
    {
        this.projects = projects;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface WallboardModel ---------------------

    public List<ProjectModel> getProjects()
    {
        return projects;
    }
}
