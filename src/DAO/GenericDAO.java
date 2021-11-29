package DAO;
import java.util.List;

public interface GenericDAO<T> {
    public List<T> listarTodos(Class cl);
    public T listar(Class cl, int id);
    public void atualizar(T t);
    public void salvar(T t);
    public void delete(T t);
}
