import { useSelector } from "react-redux"
import { Navigate } from "react-router-dom";


const ProtectRouter = ({children}) => {
    const {isLogin} = useSelector(state => state.user);
    if(isLogin) {
        return children;
    }
    return <Navigate to="/login" />
}

export default ProtectRouter;