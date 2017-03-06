package by.epam.tr.lesson11.view;

import by.epam.tr.lesson11.controller.Controller;
import by.epam.tr.lesson11.model.ModelData;

/**
 * Created by Igor_Kartun on 3/1/2017.
 */
public interface View {
    void refresh(ModelData modelData);

    void setController(Controller controller);
}
