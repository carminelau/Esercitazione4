package Visitor;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import Operation.*;
import Statement.*;
import org.w3c.dom.Document;

import org.w3c.dom.Element;
import Node.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class XmlGenerator implements Visitor {

    private Document document;

    public XmlGenerator() throws ParserConfigurationException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
    }

    @Override
    public Object visit(ProgramOp p) {
        Element programElement = document.createElement("ProgramOp");

        Element e = (Element) p.getVarDeclOpList().accept(this);
        programElement.appendChild(e);

        Element e1 = (Element) p.getProcOpList().accept(this);
        programElement.appendChild(e1);
        document.appendChild(programElement);

        return document;
    }

    @Override
    public Object visit(VarDeclListOp varDeclList) {
        Element varDeclListElement = document.createElement("varDeclListOp");
        for (VarDeclOp varDecl : varDeclList.getList()) {
            Element e = (Element) varDecl.accept(this);
            varDeclListElement.appendChild(e);
        }
        return varDeclListElement;

    }

    @Override
    public Object visit(VarDeclOp varDecl) {
        Element varDeclElement = document.createElement("varDecOp");

        varDeclElement.appendChild(document.createTextNode((String) varDecl.getTipo().accept(this)));
        varDeclElement.appendChild((Element) varDecl.getList().accept(this));
        return varDeclElement;
    }

    public Object visit(IdListInitOp idListInitOp) {
        Element idLinistInitOpElement = document.createElement("idListInitOp");

        HashMap<String, ExprOp> list = idListInitOp.getList();
        Set<Map.Entry<String, ExprOp>> set = list.entrySet();

        for (Map.Entry<String, ExprOp> elementSet : set) {
            idLinistInitOpElement.appendChild(document.createTextNode("(Id,\"" + elementSet.getKey() + "\")"));
            Element e = (Element) elementSet.getValue().accept(this);
            idLinistInitOpElement.appendChild(e);
        }
        return idLinistInitOpElement;
    }

    @Override
    public Object visit(ProcListOp procList) {
        Element procListElement = document.createElement("procListOp");
        for (ProcOp proc : procList.getList()) {
            Element e = (Element) proc.accept(this);
            procListElement.appendChild(e);
        }
        return procListElement;
    }

    @Override
    public Object visit(ProcOp proc) {
        Element procElement = document.createElement("procOp");
        procElement.appendChild(document.createTextNode(proc.getId()));//nome funzione
        procElement.appendChild((Element) proc.getParamList().accept(this));//parameetri funzione
        procElement.appendChild((Element) proc.getResultTypeList().accept(this));//tipo di ritorno
        procElement.appendChild((Element) proc.getVarList().accept(this)); // variabili locali alla funzione
        if (proc.getStatList() != null) {
            procElement.appendChild((Element) proc.getStatList().accept(this));//statement funzione
        }
        if (proc.getReturnExprs() != null) {
            procElement.appendChild((Element) proc.getReturnExprs().accept(this)); //valori di ritorno funzione
        }

        return procElement;
    }

    @Override
    public Object visit(ParamDeclListOp paramDeclListOp) {
        Element paramListElement = document.createElement("ParDeclListOp");
        for (ParDeclOp parDecl : paramDeclListOp.getList()) {
            paramListElement.appendChild((Element) parDecl.accept(this));
        }
        return paramListElement;
    }

    @Override
    public Object visit(ParDeclOp parDecl) {
        Element paramElement = document.createElement("ParDeclOp");
        paramElement.appendChild(document.createTextNode("(type,\"" + parDecl.getT().getTipo() + "\")"));
        if (!parDecl.getT().getTipo().equals("Void")) {
            paramElement.appendChild((Element) parDecl.getList().accept(this));
        }
        return paramElement;
    }

    @Override
    public Object visit(IdListOp idListOp) {
        Element idListElement = document.createElement("IdListOp");
        for (String s : idListOp.getIdList()) {
            idListElement.appendChild(document.createTextNode("\n(ID,\"" + s + "\")\n"));
        }
        return idListElement;
    }

    @Override
    public Object visit(ResultTypeListOp resultTypeListOp) {
        Element resultTypeListElement = document.createElement("ResultTypeLstOp");
        for (ResultTypeOp resultType : resultTypeListOp.getList()) {
            resultTypeListElement.appendChild(document.createTextNode("\n(" + resultType.getT().getTipo() + ")\n"));
        }
        return resultTypeListElement;
    }

    @Override
    public Object visit(StatListOp statListOp) {
        Element statListElement = document.createElement("StatListOp");
        for (StatOp stat : statListOp.getStatements()) {
            statListElement.appendChild((Element) stat.accept(this));
        }
        return statListElement;
    }

    @Override
    public Object visit(StatOp stat) {
        Element statElement = null;
        if (stat.getStatement() instanceof AssignStatOp) {
            AssignStatOp assignStat = (AssignStatOp) stat.getStatement();
            statElement = (Element) assignStat.accept(this);
        } else if (stat.getStatement() instanceof IfStatOp) {
            IfStatOp ifStat = (IfStatOp) stat.getStatement();
            statElement = (Element) ifStat.accept(this);
        } else if (stat.getStatement() instanceof WhileStatOp) {
            WhileStatOp whileStat = (WhileStatOp) stat.getStatement();
            statElement = (Element) whileStat.accept(this);
        } else if (stat.getStatement() instanceof ReadlnStatOp) {
            ReadlnStatOp readlnStat = (ReadlnStatOp) stat.getStatement();
            statElement = (Element) readlnStat.accept(this);
        } else if (stat.getStatement() instanceof WriteStatOp) {//writeOp
            WriteStatOp writeStat = (WriteStatOp) stat.getStatement();
            statElement = (Element) writeStat.accept(this);
        } else if (stat.getStatement() instanceof CallProcOp) {//callProc
            CallProcOp callProcOp = (CallProcOp) stat.getStatement();
            statElement = (Element) callProcOp.accept(this);
        }
        return statElement;
    }

    @Override
    public Object visit(AssignStatOp assignStatOp) {
        Element statElement = document.createElement("AssignStatOp");

        Element idListElement;
        Element ExprListElement;

        idListElement = (Element) assignStatOp.getIdList().accept(this);
        ExprListElement = (Element) assignStatOp.getExprList().accept(this);

        statElement.appendChild(idListElement);
        statElement.appendChild(ExprListElement);
        return statElement;
    }

    @Override
    public Object visit(ExprListOp exprListOp) {
        Element exprListElement = document.createElement("ExprListOp");
        if(exprListOp.getExprlist()!=null) {
            for (ExprOp expr : exprListOp.getExprlist()) {
                if(expr!=null) {
                    exprListElement.appendChild((Element) expr.accept(this));
                }
            }
        }
        return exprListElement;
    }

    @Override
    public Object visit(IfStatOp ifStatOp) {
        Element statElement = document.createElement("IfStatOp");
        statElement.appendChild((Element) ifStatOp.getE().accept(this));// da finire le EXPR
        statElement.appendChild((Element) ifStatOp.getStatList().accept(this));//già implementato
        statElement.appendChild((Element) ifStatOp.getElifList().accept(this));//elifstat
        if(ifStatOp.getElseStat()!=null) {
            statElement.appendChild((Element) ifStatOp.getElseStat().accept(this));//else
        }
        return statElement;
    }

    @Override
    public Object visit(ElifListOp elifListOp) {
        Element statElement = document.createElement("ElifListOp");
        for (ElifOp elif : elifListOp.getList()) {
            statElement.appendChild((Element) elif.accept(this));
        }
        return statElement;
    }

    @Override
    public Object visit(ElifOp elifOp) {
        Element statElement = document.createElement("ElifOp");

        Element exprelement;
        Element StatListElement;

        exprelement = ((Element) elifOp.getE().accept(this));//expr da finire
        StatListElement = ((Element) elifOp.getList().accept(this));//statlistOP già implementato

        statElement.appendChild(exprelement);
        statElement.appendChild(StatListElement);

        return statElement;
    }

    @Override
    public Object visit(ElseOp elseOp) {
        Element statElement = document.createElement("ElseOp");
        statElement.appendChild((Element) elseOp.getStatList().accept(this));//statlistOP già implementato

        return statElement;
    }

    @Override
    public Object visit(WhileStatOp whileStat) {
        Element statElement = document.createElement("WhileStatOp");
        if(whileStat.getStatListOp1() != null){
        	statElement.appendChild((Element) whileStat.getStatListOp1().accept(this));//statlistOP già implementato
        }
        statElement.appendChild((Element) whileStat.getE().accept(this));
        statElement.appendChild((Element) whileStat.getStatListOp().accept(this));//statlistOP già implementato
        return statElement;
    }

    @Override
    public Object visit(ReadlnStatOp readlnStatOp) {
        Element statElement = document.createElement("ReadlnStatOp");
        statElement.appendChild((Element) readlnStatOp.getIdList().accept(this));//IdList già implementato
        return statElement;
    }

    @Override
    public Object visit(WriteStatOp writeStatOp) {
        Element statElement = document.createElement("WriteStatOp");
        statElement.appendChild((Element) writeStatOp.getExprList().accept(this));//Exprlist già implementato
        return statElement;
    }

    @Override
    public Object visit(CallProcOp callProcOp) {
        Element statElement = document.createElement("CallProcOp");
        statElement.appendChild(document.createTextNode("\n(ID,\"" + callProcOp.getId() + "\")\n"));
        if (callProcOp.getExprList() != null) {
            statElement.appendChild((Element) callProcOp.getExprList().accept(this));//Exprlist già implementato
        }
        return statElement;
    }

    @Override
    public Object visit(ReturnExprsOp returnExprsOp) {
        Element returnExprsElement = document.createElement("ReturnExprsOp");
        returnExprsElement.appendChild((Element) returnExprsOp.getList().accept(this));//Exprlist già implementato
        return returnExprsElement;
    }

    public Object visit(ExprOp expr) {
        Element exprElement = document.createElement("ExprOp");
        Operation operation = expr.getOperation();
        CallProcOp statement =(CallProcOp) expr.getStatement();
        Element e;
        if(statement != null){
            e = (Element) statement.accept(this);
            exprElement.appendChild(e);
        }else if (operation != null ) {
            e = (Element) operation.accept(this);
            exprElement.appendChild(e);
        } else {
            if (expr.getType().equals("Null")) {
                exprElement.appendChild(document.createTextNode("(" + expr.getType() + ")"));
            } else {
                exprElement.appendChild(document.createTextNode("(" + expr.getType()));
                exprElement.appendChild(document.createTextNode(",\"" + expr.getVar().toString() + "\")"));
            }
        }

        return exprElement;
    }

    @Override
    public Object visit(Operation operation) {
        Element exprElement = null;
        Element e1 = null;
        Element e2 = null;
        if (operation instanceof AddOp) {
            exprElement = document.createElement("AddOp");
        } else if (operation instanceof DiffOp) {
            exprElement = document.createElement("DiffOp");
        }else if (operation instanceof MulOp) {
            exprElement = document.createElement("MulOp");
        }else if (operation instanceof DivOp) {
            exprElement = document.createElement("DivOp");
        }else if (operation instanceof AndOp) {
            exprElement = document.createElement("AndOp");
        }else if (operation instanceof OrOp) {
            exprElement = document.createElement("OrOp");
        }else if (operation instanceof GtOp) {
            exprElement = document.createElement("GtOp");
        }else if (operation instanceof GeOp) {
            exprElement = document.createElement("GeOp");
        }else if (operation instanceof LtOp) {
            exprElement = document.createElement("LtOp");
        }else if (operation instanceof LeOp) {
            exprElement = document.createElement("LeOp");
        }else if (operation instanceof EqOp) {
            exprElement = document.createElement("EqOp");
        }else if (operation instanceof NeOp) {
            exprElement = document.createElement("NeOp");
        }else if (operation instanceof UminusOp) {
            exprElement = document.createElement("UminusOp");
        }else if (operation instanceof NotOp) {
            exprElement = document.createElement("NotOp");
        }

        e1 = (Element) operation.getE1().accept(this);
        exprElement.appendChild(e1);
        if(e2 != null) {
            e2 = (Element) operation.getE2().accept(this);
            exprElement.appendChild(e2);
        }
        return exprElement;
    }

    @Override
    public Object visit(TypeOp typeOp) {
        return typeOp.getTipo();

    }
}
