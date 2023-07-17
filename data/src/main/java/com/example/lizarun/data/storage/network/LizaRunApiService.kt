package com.example.lizarun.data.storage.network

import com.example.lizarun.data.storage.model.request.ChangeUserPasswordRequest
import com.example.lizarun.data.storage.model.request.CreateCompetitionRequest
import com.example.lizarun.data.storage.model.request.CreateExerciseRequest
import com.example.lizarun.data.storage.model.request.CreateTrainingComplexRequest
import com.example.lizarun.data.storage.model.request.CreateWorkoutRequest
import com.example.lizarun.data.storage.model.request.FillSportsmanDataRequest
import com.example.lizarun.data.storage.model.request.GetAccessTokenRequest
import com.example.lizarun.data.storage.model.request.GetCompetitionByFiltersRequest
import com.example.lizarun.data.storage.model.request.GetExercisesByFiltersRequest
import com.example.lizarun.data.storage.model.request.GetWorkoutByDateRequest
import com.example.lizarun.data.storage.model.request.LoginUserRequest
import com.example.lizarun.data.storage.model.request.RegisterUserRequest
import com.example.lizarun.data.storage.model.request.UpdateCompetitionRequest
import com.example.lizarun.data.storage.model.request.UpdateExerciseRequest
import com.example.lizarun.data.storage.model.request.UpdateSportsmanDataRequest
import com.example.lizarun.data.storage.model.request.UpdateTrainingComplexRequest
import com.example.lizarun.data.storage.model.request.UpdateUserDataRequest
import com.example.lizarun.data.storage.model.request.UpdateWorkoutForSportsmanRequest
import com.example.lizarun.data.storage.model.request.UpdateWorkoutForTrainerRequest
import com.example.lizarun.data.storage.model.response.AuthDataResponse
import com.example.lizarun.data.storage.model.response.CompetitionInListResponse
import com.example.lizarun.data.storage.model.response.CompetitionResponse
import com.example.lizarun.data.storage.model.response.ExerciseInListResponse
import com.example.lizarun.data.storage.model.response.ExerciseResponse
import com.example.lizarun.data.storage.model.response.TrainingComplexResponse
import com.example.lizarun.data.storage.model.response.UserResponse
import com.example.lizarun.data.storage.model.response.WorkoutInListResponse
import com.example.lizarun.data.storage.model.response.WorkoutResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface LizaRunApiService {
    /**
     * Competition Requests
     */
    @GET("/api/Competition/GetAll")
    fun getAllCompetitions(): Single<List<CompetitionInListResponse>>

    @GET("/api/Competition/GetByFilters")
    fun getCompetitionByFilters(@Body requestBody: GetCompetitionByFiltersRequest): Single<List<CompetitionInListResponse>>

    @GET("/api/Competition/GetById/{id}")
    fun getCompetitionById(@Path("id") id: String): Single<CompetitionResponse>

    @POST("/api/Competition/Create")
    fun createCompetition(@Body requestBody: CreateCompetitionRequest): Single<CompetitionResponse>

    @PATCH("/api/Competition/Update/{id}")
    fun updateCompetition(
        @Path("id") id: String,
        @Body requestBody: UpdateCompetitionRequest
    ): Completable

    @DELETE("/api/Competition/Delete/{id}")
    fun deleteCompetition(@Path("id") id: String): Completable

    /**
     * Exercise Requests
     */
    @GET("/api/Exercise/GetAll")
    fun getAllExercises(): Single<List<ExerciseInListResponse>>

    @GET("/api/Exercise/GetByFilters")
    fun getExercisesByFilters(@Body requestBody: GetExercisesByFiltersRequest): Single<List<ExerciseInListResponse>>

    @GET("/api/Exercise/GetById/{id}")
    fun getExerciseById(@Path("id") id: String): Single<ExerciseResponse>

    @GET("/api/Exercise/GetByName/{name}")
    fun getExerciseByName(@Path("name") name: String): Single<ExerciseResponse>

    @POST("/api/Exercise/Create")
    fun createExercise(@Body requestBody: CreateExerciseRequest): Single<ExerciseResponse>

    @PATCH("/api/Exercise/Update/{id}")
    fun updateExercise(@Path("id") id: String, requestBody: UpdateExerciseRequest): Completable

    @DELETE("/api/Exercise/Delete/{id}")
    fun deleteExercise(@Path("id") id: String): Completable

    /**
     * Training Complex Requests
     */
    @GET("/api/TrainingComplex/GetAll")
    fun getAllTrainingComplexes(): Single<List<TrainingComplexResponse>>

    @GET("/api/TrainingComplex/GetById/{id}")
    fun getTrainingComplexById(@Path("id") id: String): Single<TrainingComplexResponse>

    @POST("/api/TrainingComplex/Create")
    fun createTrainingComplex(@Body requestBody: CreateTrainingComplexRequest): Single<TrainingComplexResponse>

    @PATCH("/api/TrainingComplex/Update/{id}")
    fun updateTrainingComplex(
        @Path("id") id: String,
        @Body requestBody: UpdateTrainingComplexRequest
    ): Completable

    @DELETE("/api/TrainingComplex/Delete/{id}")
    fun deleteTrainingComplex(@Path("id") id: String): Completable

    /**
     * User Requests
     */
    @GET("/api/LizaRun/User/GetById/{userId}")
    fun getUserById(@Path("userId") id: String): Single<UserResponse>

    @POST("/api/LizaRun/User/GetAccessToken")
    fun getAccessToken(@Body requestBody: GetAccessTokenRequest): Single<AuthDataResponse>

    @POST("/api/LizaRun/User/Registration")
    fun registerUser(@Body requestBody: RegisterUserRequest): Single<AuthDataResponse>

    @POST("/api/LizaRun/User/Login")
    fun loginUser(@Body requestBody: LoginUserRequest): Single<AuthDataResponse>

    @POST("/api/LizaRun/User/Logout")
    fun logoutUser(): Completable

    @PATCH("/api/LizaRun/User/UpdateAccountData/{userId}")
    fun updateUserData(
        @Path("userId") id: String,
        @Body requestBody: UpdateUserDataRequest
    ): Completable

    @PATCH("/api/LizaRun/User/FillSportsmanData/{sportsmanId}")
    fun fillSportsmanData(
        @Path("sportsmanId") id: String,
        @Body requestBody: FillSportsmanDataRequest
    ): Completable

    @PATCH("/api/LizaRun/User/UpdateSportsmanData/{sportsmanId}")
    fun updateSportsmanData(
        @Path("sportsmanId") id: String,
        @Body requestBody: UpdateSportsmanDataRequest
    ): Completable

    @PATCH("/api/LizaRun/User/ChangePassword")
    fun changeUserPassword(@Body requestBody: ChangeUserPasswordRequest): Completable

    @PATCH("/api/LizaRun/User/PasswordReset")
    fun resetUserPassword(): Completable

    /**
     * Workout Requests
     */
    @GET("/api/Workout/GetByDate")
    fun getWorkoutByDate(@Body requestBody: GetWorkoutByDateRequest): Single<List<WorkoutInListResponse>>

    @GET("/api/Workout/GetById/{id}")
    fun getWorkoutById(@Path("id") id: String): Single<WorkoutResponse>

    @POST("/api/Workout/Create")
    fun createWorkout(@Body requestBody: CreateWorkoutRequest): Single<WorkoutInListResponse>

    @PATCH("/api/Workout/WriteComments/{id}")
    fun writeCommentsToWorkout(
        @Path("id") id: String,
        @Field("comments") comments: String
    ): Completable

    @PATCH("/api/Workout/WriteRecomendations/{id}")
    fun writeRecommendationsToWorkout(
        @Path("id") id: String,
        @Field("recomendations") recommendations: String
    ): Completable

    @PATCH("/api/Workout/UpdateForTrainer/{id}")
    fun updateWorkoutForTrainer(
        @Path("id") id: String,
        @Body requestBody: UpdateWorkoutForTrainerRequest
    ): Completable

    @PATCH("/api/Workout/UpdateForSportsman/{id}")
    fun updateWorkoutForSportsman(
        @Path("id") id: String,
        @Body requestBody: UpdateWorkoutForSportsmanRequest
    ): Completable

    @PATCH("/api/Workout/ChangeExecutionStatus/{id}")
    fun changeWorkoutExecutionStatus(
        @Path("id") id: String,
        @Field("executeStatus") executeStatus: Int
    ): Completable

    @DELETE("/api/Workout/Delete/{id}")
    fun deleteWorkout(@Path("id") id: String): Completable
}