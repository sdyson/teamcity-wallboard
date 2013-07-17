/**
 * Created By:                 Simon Dyson
 * Created:                    22/11/11
 */
package jetbrains.wallboard.model;

import jetbrains.buildServer.messages.Status;

import java.util.Date;

/**
 *
 * @author Simon Dyson
 */
public class BuildModelVo implements BuildModel
{
    private String name;
    private Date buildDate;
    private String status = Status.NORMAL.getText().toLowerCase();
    private Boolean active = true;
    private String responsible = null;
    private String timeBroken;
    private Status buildStatus;
    private String pendingChanges;
    private boolean running;

// --------------------------- CONSTRUCTORS ---------------------------

    public BuildModelVo()
    {
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public void setBuildDate(Date buildDate)
    {
        this.buildDate = buildDate;
    }

    public void setBuildStatus(Status buildStatus)
    {
        this.buildStatus = buildStatus;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPendingChanges(String pendingChanges)
    {
        this.pendingChanges = pendingChanges;
    }

    public void setResponsible(String responsible)
    {
        this.responsible = responsible;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setTimeBroken(String timeBroken)
    {
        this.timeBroken = timeBroken;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface BuildModel ---------------------

    public String getName()
    {
        return name;
    }

    public Date getBuildDate()
    {
        return buildDate;
    }

    public String getStatus()
    {
        return status;
    }

    public Boolean getActive()
    {
        return active;
    }

    public String getResponsible()
    {
        return responsible;
    }

    public String getTimeBroken()
    {
        return timeBroken;
    }

    public Status getBuildStatus()
    {
        return buildStatus;
    }

    public String getPendingChanges()
    {
        return pendingChanges;
    }

    public boolean isRunning()
    {
        return running;
    }
}
