package com.google.ortools.sat;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.GeneratedMessageV3.FieldAccessorTable;

public final class CpModelProtobuf {
   static final Descriptor internal_static_operations_research_sat_IntegerVariableProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_IntegerVariableProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_BoolArgumentProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_BoolArgumentProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_IntegerArgumentProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_IntegerArgumentProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_AllDifferentConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_AllDifferentConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_LinearConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_LinearConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_ElementConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_ElementConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_IntervalConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_IntervalConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_NoOverlapConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_NoOverlapConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_NoOverlap2DConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_NoOverlap2DConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_CumulativeConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_CumulativeConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_ReservoirConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_ReservoirConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_CircuitConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_CircuitConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_RoutesConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_RoutesConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_CircuitCoveringConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_CircuitCoveringConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_TableConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_TableConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_InverseConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_InverseConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_AutomatonConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_AutomatonConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_ConstraintProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_ConstraintProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_CpObjectiveProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_CpObjectiveProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_DecisionStrategyProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_DecisionStrategyProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_DecisionStrategyProto_AffineTransformation_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_DecisionStrategyProto_AffineTransformation_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_PartialVariableAssignment_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_PartialVariableAssignment_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_CpModelProto_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_CpModelProto_fieldAccessorTable;
   static final Descriptor internal_static_operations_research_sat_CpSolverResponse_descriptor;
   static final FieldAccessorTable internal_static_operations_research_sat_CpSolverResponse_fieldAccessorTable;
   private static FileDescriptor descriptor;

   private CpModelProtobuf() {
   }

   public static void registerAllExtensions(ExtensionRegistryLite var0) {
   }

   public static void registerAllExtensions(ExtensionRegistry var0) {
      registerAllExtensions((ExtensionRegistryLite)var0);
   }

   public static FileDescriptor getDescriptor() {
      return descriptor;
   }

   static {
      String[] var0 = new String[]{"\n\u001aortools/sat/cp_model.proto\u0012\u0017operations_research.sat\"4\n\u0014IntegerVariableProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006domain\u0018\u0002 \u0003(\u0003\"%\n\u0011BoolArgumentProto\u0012\u0010\n\bliterals\u0018\u0001 \u0003(\u0005\"4\n\u0014IntegerArgumentProto\u0012\u000e\n\u0006target\u0018\u0001 \u0001(\u0005\u0012\f\n\u0004vars\u0018\u0002 \u0003(\u0005\"+\n\u001bAllDifferentConstraintProto\u0012\f\n\u0004vars\u0018\u0001 \u0003(\u0005\"E\n\u0015LinearConstraintProto\u0012\f\n\u0004vars\u0018\u0001 \u0003(\u0005\u0012\u000e\n\u0006coeffs\u0018\u0002 \u0003(\u0003\u0012\u000e\n\u0006domain\u0018\u0003 \u0003(\u0003\"E\n\u0016ElementConstraintProto\u0012\r\n\u0005index\u0018\u0001 \u0001(\u0005\u0012\u000e\n\u0006target\u0018\u0002 \u0001(\u0005\u0012\f\n\u0004vars\u0018\u0003 \u0003(\u0005\"C\n\u0017IntervalConstraintProto\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u0012\f\n\u0004size\u0018\u0003 \u0001(\u0005\"-\n\u0018NoOverlapConstraintProto\u0012\u0011\n\tintervals\u0018\u0001 \u0003(\u0005\"p\n\u001aNoOverlap2DConstraintProto\u0012\u0013\n\u000bx_intervals\u0018\u0001 \u0003(\u0005\u0012\u0013\n\u000by_intervals\u0018\u0002 \u0003(\u0005\u0012(\n boxes_with_null_area_can_overlap\u0018\u0003 \u0001(\b\"Q\n\u0019CumulativeConstraintProto\u0012\u0010\n\bcapacity\u0018\u0001 \u0001(\u0005\u0012\u0011\n\tintervals\u0018\u0002 \u0003(\u0005\u0012\u000f\n\u0007demands\u0018\u0003 \u0003(\u0005\"q\n\u0018ReservoirConstraintProto\u0012\u0011\n\tmin_level\u0018\u0001 \u0001(\u0003\u0012\u0011\n\tmax_level\u0018\u0002 \u0001(\u0003\u0012\r\n\u0005times\u0018\u0003 \u0003(\u0005\u0012\u000f\n\u0007demands\u0018\u0004 \u0003(\u0003\u0012\u000f\n\u0007actives\u0018\u0005 \u0003(\u0005\"H\n\u0016CircuitConstraintProto\u0012\r\n\u0005tails\u0018\u0003 \u0003(\u0005\u0012\r\n\u0005heads\u0018\u0004 \u0003(\u0005\u0012\u0010\n\bliterals\u0018\u0005 \u0003(\u0005\"j\n\u0015RoutesConstraintProto\u0012\r\n\u0005tails\u0018\u0001 \u0003(\u0005\u0012\r\n\u0005heads\u0018\u0002 \u0003(\u0005\u0012\u0010\n\bliterals\u0018\u0003 \u0003(\u0005\u0012\u000f\n\u0007demands\u0018\u0004 \u0003(\u0005\u0012\u0010\n\bcapacity\u0018\u0005 \u0001(\u0003\"L\n\u001eCircuitCoveringConstraintProto\u0012\r\n\u0005nexts\u0018\u0001 \u0003(\u0005\u0012\u001b\n\u0013distinguished_nodes\u0018\u0002 \u0003(\u0003\"E\n\u0014TableConstraintProto\u0012\f\n\u0004vars\u0018\u0001 \u0003(\u0005\u0012\u000e\n\u0006values\u0018\u0002 \u0003(\u0003\u0012\u000f\n\u0007negated\u0018\u0003 \u0001(\b\"=\n\u0016InverseConstraintProto\u0012\u0010\n\bf_direct\u0018\u0001 \u0003(\u0005\u0012\u0011\n\tf_inverse\u0018\u0002 \u0003(\u0005\"¢\u0001\n\u0018AutomatonConstraintProto\u0012\u0016\n\u000estarting_state\u0018\u0002 \u0001(\u0003\u0012\u0014\n\ffinal_states\u0018\u0003 \u0003(\u0003\u0012\u0017\n\u000ftransition_tail\u0018\u0004 \u0003(\u0003\u0012\u0017\n\u000ftransition_head\u0018\u0005 \u0003(\u0003\u0012\u0018\n\u0010transition_label\u0018\u0006 \u0003(\u0003\u0012\f\n\u0004vars\u0018\u0007 \u0003(\u0005\"ý\f\n\u000fConstraintProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u001b\n\u0013enforcement_literal\u0018\u0002 \u0003(\u0005\u0012=\n\u0007bool_or\u0018\u0003 \u0001(\u000b2*.operations_research.sat.BoolArgumentProtoH\u0000\u0012>\n\bbool_and\u0018\u0004 \u0001(\u000b2*.operations_research.sat.BoolArgumentProtoH\u0000\u0012A\n\u000bat_most_one\u0018\u001a \u0001(\u000b2*.operations_research.sat.BoolArgumentProtoH\u0000\u0012>\n\bbool_xor\u0018\u0005 \u0001(\u000b2*.operations_research.sat.BoolArgumentProtoH\u0000\u0012@\n\u0007int_div\u0018\u0007 \u0001(\u000b2-.operations_research.sat.IntegerArgumentProtoH\u0000\u0012@\n\u0007int_mod\u0018\b \u0001(\u000b2-.operations_research.sat.IntegerArgumentProtoH\u0000\u0012@\n\u0007int_max\u0018\t \u0001(\u000b2-.operations_research.sat.IntegerArgumentProtoH\u0000\u0012@\n\u0007int_min\u0018\n \u0001(\u000b2-.operations_research.sat.IntegerArgumentProtoH\u0000\u0012A\n\bint_prod\u0018\u000b \u0001(\u000b2-.operations_research.sat.IntegerArgumentProtoH\u0000\u0012@\n\u0006linear\u0018\f \u0001(\u000b2..operations_research.sat.LinearConstraintProtoH\u0000\u0012H\n\ball_diff\u0018\r \u0001(\u000b24.operations_research.sat.AllDifferentConstraintProtoH\u0000\u0012B\n\u0007element\u0018\u000e \u0001(\u000b2/.operations_research.sat.ElementConstraintProtoH\u0000\u0012B\n\u0007circuit\u0018\u000f \u0001(\u000b2/.operations_research.sat.CircuitConstraintProtoH\u0000\u0012@\n\u0006routes\u0018\u0017 \u0001(\u000b2..operations_research.sat.RoutesConstraintProtoH\u0000\u0012S\n\u0010circuit_covering\u0018\u0019 \u0001(\u000b27.operations_research.sat.CircuitCoveringConstraintProtoH\u0000\u0012>\n\u0005table\u0018\u0010 \u0001(\u000b2-.operations_research.sat.TableConstraintProtoH\u0000\u0012F\n\tautomaton\u0018\u0011 \u0001(\u000b21.operations_research.sat.AutomatonConstraintProtoH\u0000\u0012B\n\u0007inverse\u0018\u0012 \u0001(\u000b2/.operations_research.sat.InverseConstraintProtoH\u0000\u0012F\n\treservoir\u0018\u0018 \u0001(\u000b21.operations_research.sat.ReservoirConstraintProtoH\u0000\u0012D\n\binterval\u0018\u0013 \u0001(\u000b20.operations_research.sat.IntervalConstraintProtoH\u0000\u0012G\n\nno_overlap\u0018\u0014 \u0001(\u000b21.operations_research.sat.NoOverlapConstraintProtoH\u0000\u0012L\n\rno_overlap_2d\u0018\u0015 \u0001(\u000b23.operations_research.sat.NoOverlap2DConstraintProtoH\u0000\u0012H\n\ncumulative\u0018\u0016 \u0001(\u000b22.operations_research.sat.CumulativeConstraintProtoH\u0000B\f\n\nconstraint\"h\n\u0010CpObjectiveProto\u0012\f\n\u0004vars\u0018\u0001 \u0003(\u0005\u0012\u000e\n\u0006coeffs\u0018\u0004 \u0003(\u0003\u0012\u000e\n\u0006offset\u0018\u0002 \u0001(\u0001\u0012\u0016\n\u000escaling_factor\u0018\u0003 \u0001(\u0001\u0012\u000e\n\u0006domain\u0018\u0005 \u0003(\u0003\"Õ\u0005\n\u0015DecisionStrategyProto\u0012\u0011\n\tvariables\u0018\u0001 \u0003(\u0005\u0012m\n\u001bvariable_selection_strategy\u0018\u0002 \u0001(\u000e2H.operations_research.sat.DecisionStrategyProto.VariableSelectionStrategy\u0012i\n\u0019domain_reduction_strategy\u0018\u0003 \u0001(\u000e2F.operations_research.sat.DecisionStrategyProto.DomainReductionStrategy\u0012\\\n\u000ftransformations\u0018\u0004 \u0003(\u000b2C.operations_research.sat.DecisionStrategyProto.AffineTransformation\u001aK\n\u0014AffineTransformation\u0012\u000b\n\u0003var\u0018\u0001 \u0001(\u0005\u0012\u000e\n\u0006offset\u0018\u0002 \u0001(\u0003\u0012\u0016\n\u000epositive_coeff\u0018\u0003 \u0001(\u0003\"\u0094\u0001\n\u0019VariableSelectionStrategy\u0012\u0010\n\fCHOOSE_FIRST\u0010\u0000\u0012\u0015\n\u0011CHOOSE_LOWEST_MIN\u0010\u0001\u0012\u0016\n\u0012CHOOSE_HIGHEST_MAX\u0010\u0002\u0012\u001a\n\u0016CHOOSE_MIN_DOMAIN_SIZE\u0010\u0003\u0012\u001a\n\u0016CHOOSE_MAX_DOMAIN_SIZE\u0010\u0004\"\u008c\u0001\n\u0017DomainReductionStrategy\u0012\u0014\n\u0010SELECT_MIN_VALUE\u0010\u0000\u0012\u0014\n\u0010SELECT_MAX_VALUE\u0010\u0001\u0012\u0015\n\u0011SELECT_LOWER_HALF\u0010\u0002\u0012\u0015\n\u0011SELECT_UPPER_HALF\u0010\u0003\u0012\u0017\n\u0013SELECT_MEDIAN_VALUE\u0010\u0004\"9\n\u0019PartialVariableAssignment\u0012\f\n\u0004vars\u0018\u0001 \u0003(\u0005\u0012\u000e\n\u0006values\u0018\u0002 \u0003(\u0003\"ï\u0002\n\fCpModelProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012@\n\tvariables\u0018\u0002 \u0003(\u000b2-.operations_research.sat.IntegerVariableProto\u0012=\n\u000bconstraints\u0018\u0003 \u0003(\u000b2(.operations_research.sat.ConstraintProto\u0012<\n\tobjective\u0018\u0004 \u0001(\u000b2).operations_research.sat.CpObjectiveProto\u0012G\n\u000fsearch_strategy\u0018\u0005 \u0003(\u000b2..operations_research.sat.DecisionStrategyProto\u0012I\n\rsolution_hint\u0018\u0006 \u0001(\u000b22.operations_research.sat.PartialVariableAssignment\"¸\u0004\n\u0010CpSolverResponse\u00127\n\u0006status\u0018\u0001 \u0001(\u000e2'.operations_research.sat.CpSolverStatus\u0012\u0010\n\bsolution\u0018\u0002 \u0003(\u0003\u0012\u0017\n\u000fobjective_value\u0018\u0003 \u0001(\u0001\u0012\u001c\n\u0014best_objective_bound\u0018\u0004 \u0001(\u0001\u0012\u001d\n\u0015solution_lower_bounds\u0018\u0012 \u0003(\u0003\u0012\u001d\n\u0015solution_upper_bounds\u0018\u0013 \u0003(\u0003\u0012J\n\u0013tightened_variables\u0018\u0015 \u0003(\u000b2-.operations_research.sat.IntegerVariableProto\u0012 \n\u0018all_solutions_were_found\u0018\u0005 \u0001(\b\u0012\u0014\n\fnum_booleans\u0018\n \u0001(\u0003\u0012\u0015\n\rnum_conflicts\u0018\u000b \u0001(\u0003\u0012\u0014\n\fnum_branches\u0018\f \u0001(\u0003\u0012\u001f\n\u0017num_binary_propagations\u0018\r \u0001(\u0003\u0012 \n\u0018num_integer_propagations\u0018\u000e \u0001(\u0003\u0012\u0011\n\twall_time\u0018\u000f \u0001(\u0001\u0012\u0011\n\tuser_time\u0018\u0010 \u0001(\u0001\u0012\u001a\n\u0012deterministic_time\u0018\u0011 \u0001(\u0001\u0012\u0017\n\u000fprimal_integral\u0018\u0016 \u0001(\u0001\u0012\u0015\n\rsolution_info\u0018\u0014 \u0001(\t*[\n\u000eCpSolverStatus\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u0011\n\rMODEL_INVALID\u0010\u0001\u0012\f\n\bFEASIBLE\u0010\u0002\u0012\u000e\n\nINFEASIBLE\u0010\u0003\u0012\u000b\n\u0007OPTIMAL\u0010\u0004B@\n\u0016com.google.ortools.satB\u000fCpModelProtobufP\u0001ª\u0002\u0012Google.OrTools.Satb\u0006proto3"};
      descriptor = FileDescriptor.internalBuildGeneratedFileFrom(var0, new FileDescriptor[0]);
      internal_static_operations_research_sat_IntegerVariableProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(0);
      internal_static_operations_research_sat_IntegerVariableProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_IntegerVariableProto_descriptor, new String[]{"Name", "Domain"});
      internal_static_operations_research_sat_BoolArgumentProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(1);
      internal_static_operations_research_sat_BoolArgumentProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_BoolArgumentProto_descriptor, new String[]{"Literals"});
      internal_static_operations_research_sat_IntegerArgumentProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(2);
      internal_static_operations_research_sat_IntegerArgumentProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_IntegerArgumentProto_descriptor, new String[]{"Target", "Vars"});
      internal_static_operations_research_sat_AllDifferentConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(3);
      internal_static_operations_research_sat_AllDifferentConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_AllDifferentConstraintProto_descriptor, new String[]{"Vars"});
      internal_static_operations_research_sat_LinearConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(4);
      internal_static_operations_research_sat_LinearConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_LinearConstraintProto_descriptor, new String[]{"Vars", "Coeffs", "Domain"});
      internal_static_operations_research_sat_ElementConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(5);
      internal_static_operations_research_sat_ElementConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_ElementConstraintProto_descriptor, new String[]{"Index", "Target", "Vars"});
      internal_static_operations_research_sat_IntervalConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(6);
      internal_static_operations_research_sat_IntervalConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_IntervalConstraintProto_descriptor, new String[]{"Start", "End", "Size"});
      internal_static_operations_research_sat_NoOverlapConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(7);
      internal_static_operations_research_sat_NoOverlapConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_NoOverlapConstraintProto_descriptor, new String[]{"Intervals"});
      internal_static_operations_research_sat_NoOverlap2DConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(8);
      internal_static_operations_research_sat_NoOverlap2DConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_NoOverlap2DConstraintProto_descriptor, new String[]{"XIntervals", "YIntervals", "BoxesWithNullAreaCanOverlap"});
      internal_static_operations_research_sat_CumulativeConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(9);
      internal_static_operations_research_sat_CumulativeConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_CumulativeConstraintProto_descriptor, new String[]{"Capacity", "Intervals", "Demands"});
      internal_static_operations_research_sat_ReservoirConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(10);
      internal_static_operations_research_sat_ReservoirConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_ReservoirConstraintProto_descriptor, new String[]{"MinLevel", "MaxLevel", "Times", "Demands", "Actives"});
      internal_static_operations_research_sat_CircuitConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(11);
      internal_static_operations_research_sat_CircuitConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_CircuitConstraintProto_descriptor, new String[]{"Tails", "Heads", "Literals"});
      internal_static_operations_research_sat_RoutesConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(12);
      internal_static_operations_research_sat_RoutesConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_RoutesConstraintProto_descriptor, new String[]{"Tails", "Heads", "Literals", "Demands", "Capacity"});
      internal_static_operations_research_sat_CircuitCoveringConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(13);
      internal_static_operations_research_sat_CircuitCoveringConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_CircuitCoveringConstraintProto_descriptor, new String[]{"Nexts", "DistinguishedNodes"});
      internal_static_operations_research_sat_TableConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(14);
      internal_static_operations_research_sat_TableConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_TableConstraintProto_descriptor, new String[]{"Vars", "Values", "Negated"});
      internal_static_operations_research_sat_InverseConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(15);
      internal_static_operations_research_sat_InverseConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_InverseConstraintProto_descriptor, new String[]{"FDirect", "FInverse"});
      internal_static_operations_research_sat_AutomatonConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(16);
      internal_static_operations_research_sat_AutomatonConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_AutomatonConstraintProto_descriptor, new String[]{"StartingState", "FinalStates", "TransitionTail", "TransitionHead", "TransitionLabel", "Vars"});
      internal_static_operations_research_sat_ConstraintProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(17);
      internal_static_operations_research_sat_ConstraintProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_ConstraintProto_descriptor, new String[]{"Name", "EnforcementLiteral", "BoolOr", "BoolAnd", "AtMostOne", "BoolXor", "IntDiv", "IntMod", "IntMax", "IntMin", "IntProd", "Linear", "AllDiff", "Element", "Circuit", "Routes", "CircuitCovering", "Table", "Automaton", "Inverse", "Reservoir", "Interval", "NoOverlap", "NoOverlap2D", "Cumulative", "Constraint"});
      internal_static_operations_research_sat_CpObjectiveProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(18);
      internal_static_operations_research_sat_CpObjectiveProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_CpObjectiveProto_descriptor, new String[]{"Vars", "Coeffs", "Offset", "ScalingFactor", "Domain"});
      internal_static_operations_research_sat_DecisionStrategyProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(19);
      internal_static_operations_research_sat_DecisionStrategyProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_DecisionStrategyProto_descriptor, new String[]{"Variables", "VariableSelectionStrategy", "DomainReductionStrategy", "Transformations"});
      internal_static_operations_research_sat_DecisionStrategyProto_AffineTransformation_descriptor = (Descriptor)internal_static_operations_research_sat_DecisionStrategyProto_descriptor.getNestedTypes().get(0);
      internal_static_operations_research_sat_DecisionStrategyProto_AffineTransformation_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_DecisionStrategyProto_AffineTransformation_descriptor, new String[]{"Var", "Offset", "PositiveCoeff"});
      internal_static_operations_research_sat_PartialVariableAssignment_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(20);
      internal_static_operations_research_sat_PartialVariableAssignment_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_PartialVariableAssignment_descriptor, new String[]{"Vars", "Values"});
      internal_static_operations_research_sat_CpModelProto_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(21);
      internal_static_operations_research_sat_CpModelProto_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_CpModelProto_descriptor, new String[]{"Name", "Variables", "Constraints", "Objective", "SearchStrategy", "SolutionHint"});
      internal_static_operations_research_sat_CpSolverResponse_descriptor = (Descriptor)getDescriptor().getMessageTypes().get(22);
      internal_static_operations_research_sat_CpSolverResponse_fieldAccessorTable = new FieldAccessorTable(internal_static_operations_research_sat_CpSolverResponse_descriptor, new String[]{"Status", "Solution", "ObjectiveValue", "BestObjectiveBound", "SolutionLowerBounds", "SolutionUpperBounds", "TightenedVariables", "AllSolutionsWereFound", "NumBooleans", "NumConflicts", "NumBranches", "NumBinaryPropagations", "NumIntegerPropagations", "WallTime", "UserTime", "DeterministicTime", "PrimalIntegral", "SolutionInfo"});
   }
}
