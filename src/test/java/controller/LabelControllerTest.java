package controller;

import dao.LabelDao;
import model.Label;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.LabelService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class LabelControllerTest {

    private final LabelDao labelDaoMock = Mockito.mock(LabelDao.class);
    private final LabelService labelService = new LabelService(labelDaoMock);
    private final LabelController labelController = new LabelController(labelService);

    @Test
    void givenListOfLabels_whenRun_thenEqualListOfLabelsReturned() {
        List<Label> labels = new ArrayList<>();
        labels.add(new Label( "First Label"));
        labels.add(new Label( "Second Label"));
        when(labelController.getAll()).thenReturn(labels);

        List<Label> testLabels = labelController.getAll();

        assertEquals(labels, testLabels);
    }

    @Test
    void givenId_whenRun_thenLabelWithThatIdReturned() {
        List<Label> labels = new ArrayList<>();
        labels.add(new Label( "First Label"));
        labels.add(new Label("Second Label"));

        when(labelController.getById(1)).thenReturn(labels.get(0));
        when(labelController.getById(2)).thenReturn(labels.get(1));

        Label testLabel = labelController.getById(1);
        Label testLabel2 = labelController.getById(2);

        assertEquals("First Label", testLabel.getName());
        assertEquals("Second Label", testLabel2.getName());
    }

    @Test
    void givenNewLabel_whenSave_thenReturnNewLabel() {
        LabelController labelController = Mockito.mock(LabelController.class);
        List<Label> labels = new ArrayList<>();
        labels.add(new Label("First Label"));
        labels.add(new Label("Second Label"));
        Label newLabel = new Label("Third Label");
        doNothing().when(labelController).saveLabel(isA(Label.class));

        labelController.saveLabel(newLabel);

        verify(labelController, times(1)).saveLabel(newLabel);
    }

    @Test
    void givenUpdate_whenUpdate_thenReturnUpdatedLabel() {
        LabelController labelController = Mockito.mock(LabelController.class);
        List<Label> labels = new ArrayList<>();
        labels.add(new Label("First Label"));
        labels.add(new Label("Second Label"));
        Label newLabel = new Label("Third Label");

        doNothing().when(labelController).updateLabel(newLabel);

        labelController.updateLabel(newLabel);

        verify(labelController, times(1)).updateLabel(newLabel);
    }

    @Test
    void givenId_whenRun_thenVerifyTimesOfInvocations() {
        LabelController labelController = Mockito.mock(LabelController.class);
        doNothing().when(labelController).deleteLabelById(isA(Integer.class));

        labelController.deleteLabelById(1);

        verify(labelController, times(1)).deleteLabelById(1);
    }
}