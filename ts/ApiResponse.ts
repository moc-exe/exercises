type Success<T> = {
  success: true;
  data: T;
};

type Failure = {
    success: false, 
    error: string
};

type ApiResponse<T> = Success<T> | Failure;

function createSuccess<T>(data: T): ApiResponse<T>{

    return {
        success: true,
        data: data
    }

};

function createError<T>(message: string): ApiResponse<T>{

    return {
        success: false,
        error: message
    }
};

function unwrapOrThrow<T>(response: ApiResponse<T>) : T {
    if(!response.success) throw new Error(response.error);
    return response.data;
};
