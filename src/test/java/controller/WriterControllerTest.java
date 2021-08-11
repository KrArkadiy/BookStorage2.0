package controller;

import dao.WriterDao;
import model.Writer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.WriterService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class WriterControllerTest {

    private final WriterDao writerDaoMock = Mockito.mock(WriterDao.class);
    private final WriterService writerService = new WriterService(writerDaoMock);
    private final WriterController writerController = new WriterController(writerService);

    @Test
    void givenListOfWriters_whenRun_thenEqualListOfWritersReturned() {
        List<Writer> writers = new ArrayList<>();
        writers.add(new Writer("First Name"));
        writers.add(new Writer("Second Name"));
        when(writerController.getAll()).thenReturn(writers);

        List<Writer> testWriters = writerController.getAll();

        assertEquals(writers, testWriters);
    }

    @Test
    void givenId_whenRun_thenWriterWithThatIdReturned() {
        List<Writer> writers = new ArrayList<>();
        writers.add(new Writer("First Name"));
        writers.add(new Writer("Second Name"));

        when(writerController.getWriterById(1)).thenReturn(writers.get(0));
        when(writerController.getWriterById(2)).thenReturn(writers.get(1));

        Writer testWriter = writerController.getWriterById(1);
        Writer testWriter2 = writerController.getWriterById(2);

        assertEquals("First Name", testWriter.getName());
        assertEquals("Second Name", testWriter2.getName());
    }

    @Test
    void givenNewWriter_whenSave_thenReturnNewWriter() {
        WriterController writerController = Mockito.mock(WriterController.class);
        List<Writer> writers = new ArrayList<>();
        writers.add(new Writer("First Name"));
        writers.add(new Writer("Second Name"));
        Writer newWriter = new Writer("Writer Name");

        doNothing().when(writerController).saveWriter(isA(Writer.class));

        writerController.saveWriter(newWriter);

        verify(writerController, times(1)).saveWriter(isA(Writer.class));
    }

    @Test
    void givenUpdate_whenUpdate_thenReturnUpdatedWriter() {
        WriterController writerController = Mockito.mock(WriterController.class);
        List<Writer> writers = new ArrayList<>();
        writers.add(new Writer("First Name"));
        writers.add(new Writer("Second Name"));
        Writer newWriter = new Writer("Writer Name");

        doNothing().when(writerController).updateWriter(isA(Writer.class));

        writerController.updateWriter(newWriter);

        verify(writerController, times(1)).updateWriter(isA(Writer.class));
    }

    @Test
    void givenId_whenRun_thenVerifyTimesOfInvocations() {
        WriterController writerController = Mockito.mock(WriterController.class);
        doNothing().when(writerController).deleteWriterById(isA(Integer.class));

        writerController.deleteWriterById(1);

        verify(writerController, times(1)).deleteWriterById(1);
    }
}