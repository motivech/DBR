import { Route, Routes } from "react-router-dom"
import Main from "../pages/Main/Main";
import Profile from "../pages/Profile/Profile";
import Tests from "../pages/Tests/Tests";
import Layout from "../components/Layout/Layout";
import Login from "../pages/Login/Login";
import Register from "../pages/Register/Register";
import ProtectRouter from "../hoc/ProtectRouter";

const AppRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<Layout><Main /></Layout>} />
            <Route path="/profile" element={<ProtectRouter><Layout><Profile /></Layout></ProtectRouter>} />
            <Route path="/tests" element={<Layout><Tests /></Layout>} />
            <Route path="/login" element={<Layout><Login /></Layout>} />
            <Route path="/register" element={<Layout><Register /></Layout>} />
        </Routes>
    )
}

export default AppRouter;