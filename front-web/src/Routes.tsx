import { BrowserRouter, Route, Switch } from "react-router-dom";
import Footer from "./footer";
import Home from "./home";
import NavBar from "./navbar";
import Order from "./orders";

function Routes() {
    return (
        <BrowserRouter>
            <NavBar />
            <Switch>
                <Route path="/orders">
                    <Order/>
                </Route>
                <Route path ="/">
                    <Home/>
                </Route>

            </Switch>
            <Footer />
        </BrowserRouter>
    )
}

export default Routes;