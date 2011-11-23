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
public interface ProjectModel
{
    List<BuildModel> getBuilds();

    String getName();

    Boolean getActive();

    String getStatus();
}
