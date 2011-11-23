/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.model;

import jetbrains.buildServer.messages.Status;

import java.util.List;

/**
 *
 * @author Simon Dyson
 */
public class ProjectModelVo implements ProjectModel
{
    private String name;
    private Boolean active = true;
    private String status = Status.NORMAL.getText().toLowerCase();
    private List<BuildModel> builds;

// --------------------------- CONSTRUCTORS ---------------------------

    public ProjectModelVo()
    {
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public void setBuilds(List<BuildModel> builds)
    {
        this.builds = builds;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface ProjectModel ---------------------


    public List<BuildModel> getBuilds()
    {
        return builds;
    }

    public String getName()
    {
        return name;
    }

    public Boolean getActive()
    {
        return active;
    }

    public String getStatus()
    {
        return status;
    }
}
