import { createSlice } from "@reduxjs/toolkit"


const initialState = {
    isLogin: false,
    user: {},
}

const userSlice = createSlice({
    name: "user",
    initialState,
    reducers: {
        toggleLoggin(state, action) {
            state.isLogin = action.payload;
        },
        saveUserInfo(state, action) {
            state.user = action.payload;
        }
    }
})

export const { toggleLoggin, saveUserInfo } = userSlice.actions;

export default userSlice.reducer;