interface ApiResponse<T> {
  success: boolean;
  data?: T;
  error?: string;
}

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
