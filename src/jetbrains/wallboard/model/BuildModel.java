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
public interface BuildModel
{
    String getName();

    Date getBuildDate();

    String getStatus();

    Boolean getActive();

    String getResponsible();

    String getTimeBroken();

    Status getBuildStatus();

    String getPendingChanges();

    boolean isRunning();
}
