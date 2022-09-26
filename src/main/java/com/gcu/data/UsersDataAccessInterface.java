package com.gcu.data;

/*
 * <T> where T is the place holder for the model (parameter data type).
 * t is the place holder for the parameter name.
 * An interface is an abstract class that is used to group related methods with "empty" bodies.
 */
public interface UsersDataAccessInterface<T>
{
	public T findByUsername(String username);
}
